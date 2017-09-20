package cn.com.wservice.mcproj.ecoupon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangz on 2017/9/18.
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    public String error() {
        return "hello";
    }
}
