package cn.com.wservice.mcproj;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@Log
@SpringBootApplication
public class BaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApiApplication.class, args);
	}
}
