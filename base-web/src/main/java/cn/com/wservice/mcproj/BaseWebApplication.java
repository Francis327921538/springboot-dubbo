package cn.com.wservice.mcproj;

import cn.com.wservice.mcproj.web.service.UserManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaseWebApplication {
	public static void main(String[] args) {
//		SpringApplication.run(BaseWebApplication.class, args);
		ConfigurableApplicationContext run = SpringApplication.run(BaseWebApplication.class, args);
		UserManager userManager = run.getBean(UserManager.class);
		System.out.println(userManager.userService.getUser(1));
	}
}


