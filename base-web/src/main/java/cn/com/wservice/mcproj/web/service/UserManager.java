package cn.com.wservice.mcproj.web.service;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by zhangz on 2017/9/15.
 */
@Component
public class UserManager {

    @Reference(version = "1.0.0")
    public UserService userService;

}
