package cn.com.wservice.mcproj.ecoupon.shiro;

import cn.com.wservice.mcproj.api.domain.Permission;
import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.ecoupon.enums.UserAccountStateEnum;
import cn.com.wservice.mcproj.ecoupon.service.ServerManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private ServerManager serverManager;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        UserAccount user = serverManager.userService.getByUsername((String) principals.getPrimaryPrincipal());

        //赋予角色
//        for (Role userRole : user.getRoles()) {
//            info.addRole(userRole.getRoleName());
//        }
        info.addRoles(user.getRoleNames());
        //赋予权限
        for (Permission permission : serverManager.permissionService.getByRole(user.getRoles())) {
            info.addStringPermission(permission.getPermissionIdentifier());
        }
        //设置登录次数、时间
//         userService.updateUserLogin(user);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        UserAccount user = serverManager.userService.getByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(UserAccountStateEnum.LOCKED.getIndex() == user.getState()) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getAccount(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
