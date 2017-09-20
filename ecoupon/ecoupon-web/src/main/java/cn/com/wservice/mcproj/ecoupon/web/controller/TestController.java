package cn.com.wservice.mcproj.ecoupon.web.controller;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.ecoupon.service.ServerManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangz on 2017/9/15.
 */
@RestController
public class TestController {

    @Resource
    private ServerManager serverManager;
//
//    @GetMapping("/hello")
//    public UserAccount hello() {
//        return serverManager.userService.getUser(1);
//    }
}
