package cn.com.wservice.mcproj;

import cn.com.wservice.mcproj.api.domain.Role;
import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.api.service.PermissionService;
import cn.com.wservice.mcproj.api.service.RoleService;
import cn.com.wservice.mcproj.api.service.UserService;
import cn.com.wservice.mcproj.repository.UserAccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class)
public class BaseServiceApplicationTests {

	@Resource
	private UserAccountRepository userAccountRepository;
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private PermissionService permissionService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUser() {
//		System.out.println(userAccountRepository.findAll());
//		System.err.println(userService.getAll());
		Role role = new Role();
		role.setName("dasd");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		UserAccount userAccount = userAccountRepository.findOne(1);
		userAccount.setRoles(roles);
		userService.updateUser(userAccount);
	}

}
