package cn.com.wservice.mcproj.repository;

import cn.com.wservice.mcproj.api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by zhangz on 2017/7/18.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findByNameContaining(String roleName);
	
	
}
