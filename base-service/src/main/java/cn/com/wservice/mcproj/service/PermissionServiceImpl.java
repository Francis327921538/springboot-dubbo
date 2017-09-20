package cn.com.wservice.mcproj.service;

import cn.com.wservice.mcproj.api.domain.Permission;
import cn.com.wservice.mcproj.api.domain.Role;
import cn.com.wservice.mcproj.api.service.PermissionService;
import cn.com.wservice.mcproj.repository.PermissionRepository;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
@Service(version = "1.0.0")
public class PermissionServiceImpl implements PermissionService {

    private @Resource
    PermissionRepository permissionRepository;

    @Override
    public void deletePermission(int id) {
        System.out.println(id);
        Permission permission = permissionRepository.findOne(id);
        System.out.println(permission.getChildren());
        permission.getParent().getChildren().remove(permission);
        permission.setParent(null);
        permission.setRoles(null);
        permissionRepository.delete(permission);
    }

    @Override
    public void createPermission(Permission permission) {
        Permission parent = permissionRepository.findOne(permission.getParent().getId());
        permission.setParent(parent);
        System.out.println(permission.getId());
        permissionRepository.save(permission);
    }

    @Override
    public Set<Permission> getAll() {
        return permissionRepository.findOne(1).getChildren();
    }

    @Override
    public Set<Permission> getByRole(Set<Role> roles) {
        return permissionRepository.findByRoles(roles);
    }

	@Override
	public void updatePermission(Permission permission) {
		Permission perm = permissionRepository.findOne(permission.getId());
		perm.setPermissionIdentifier(permission.getPermissionIdentifier());
		perm.setPermissionName(permission.getPermissionName());
        permissionRepository.saveAndFlush(perm);
	}
}
