package cn.com.wservice.mcproj.ecoupon.service;

import cn.com.wservice.mcproj.api.service.PermissionService;
import cn.com.wservice.mcproj.api.service.RoleService;
import cn.com.wservice.mcproj.api.service.UserService;
import cn.com.wservice.mcproj.ecoupon.business.api.service.ElectronicCouponService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.monitor.MonitorService;
import org.springframework.stereotype.Component;

/**
 * Created by zhangz on 2017/9/15.
 */
@Component
public class ServerManager {

    @Reference(version = "1.0.0")
    public UserService userService;
    @Reference(version = "1.0.0")
    public RoleService roleService;
    @Reference(version = "1.0.0")
    public PermissionService permissionService;
    @Reference(version = "1.0.0")
    public ElectronicCouponService electronicCouponService;

}
