package cn.com.wservice.mcproj;

import cn.com.wservice.mcproj.ecoupon.business.api.entity.ElectronicCoupon;
import cn.com.wservice.mcproj.ecoupon.business.api.service.ElectronicCouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = McprojEcouponBusinessApplication.class)
public class McprojEcouponBusinessApplicationTests {

	@Resource
	private ElectronicCouponService electronicCouponService;

	@Test
	public void contextLoads() {
//		System.out.println(electronicCouponService.listAll());
//		System.out.println(electronicCouponService.create(new ElectronicCoupon()));
		ElectronicCoupon electronicCoupon = electronicCouponService.getOne(1);
		electronicCoupon.setCoding("aa");
//		electronicCouponService.update(electronicCoupon);
		electronicCouponService.search(electronicCoupon, new PageRequest(0, 10)).forEach(e -> {
			System.out.println(e.toString());
		});
	}

}
