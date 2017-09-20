package cn.com.wservice.mcproj.web.action;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.web.service.UserManager;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangz on 2017/9/15.
 */
@RestController
public class TestController {

    @Resource
    private UserManager userManager;

    @GetMapping("/hello")
    public UserAccount hello() {
        return userManager.userService.getUser(1);
    }
}
