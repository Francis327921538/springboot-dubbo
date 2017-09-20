package cn.com.wservice.mcproj;

import cn.com.wservice.mcproj.ecoupon.service.ServerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcouponWebApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EcouponWebApplication.class, args);
		ConfigurableApplicationContext run = SpringApplication.run(EcouponWebApplication.class, args);
		ServerManager serverManager = run.getBean(ServerManager.class);
		System.out.println(serverManager.userService.getUser(1));
		System.out.println(serverManager.userService.getAll());
		System.out.println(serverManager.electronicCouponService.listAll());
		System.out.println(serverManager.electronicCouponService.getOne(1).toString()+"=================");
	}
}
