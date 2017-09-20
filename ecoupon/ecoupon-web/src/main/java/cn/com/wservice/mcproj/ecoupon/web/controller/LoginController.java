package cn.com.wservice.mcproj.ecoupon.web.controller;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.ecoupon.service.ServerManager;
import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zhangz on 2017/7/18.
 */
@Log
@RestController
public class LoginController extends ResultController {

    @Resource
    ServerManager serverManager;


    @PostMapping(value = "/login")
    public Map<String, Object> login(String username, String password, HttpServletResponse response, HttpServletRequest request, final RedirectAttributes redirectAttributes) {

        AuthenticationToken token = new UsernamePasswordToken(username, password, false);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            log.info("登录成功================================");
            String loginUserName=(String)subject.getPrincipal();
        } catch (UnknownAccountException e) {
            return resultMap(false, "账号/密码错误");
        } catch (IncorrectCredentialsException e) {
            return resultMap(false, "账号/密码错误");
        } catch (ExcessiveAttemptsException e) {
            return resultMap(false, "错误输入过多");
        } catch (LockedAccountException e) {
            return resultMap(false, "账户被锁定");
        }  catch (Exception e) {
            return resultMap(false, "登录失败，未知异常");
        }
        String referUrl = null == WebUtils.getSavedRequest(request)?"/":WebUtils.getSavedRequest(request).getRequestUrl();
        log.info("refUrl================================"+referUrl);
        return resultMap(true, "登录成功", referUrl.substring(1));
    }


    @PostMapping("/register")
    public Map<String, Object> register(String userName, String password) {
        if (null != serverManager.userService.getByUsername(userName)) {
            return resultMap(false, "用户已存在", userName);
        } else {
            UserAccount user = new UserAccount();
            user.setPassword("");
            user.setPlainPassword(password);
            user.setAccount(userName);
            serverManager.userService.createUser(user);
            return resultMap(true, "注册成功", user);
        }
    }
}