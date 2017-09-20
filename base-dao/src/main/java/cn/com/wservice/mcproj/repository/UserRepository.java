package cn.com.wservice.mcproj.repository;

import cn.com.wservice.mcproj.api.domain.Role;
import cn.com.wservice.mcproj.api.domain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;


/**
 * Created by zhangz on 2017/7/18.
 */
public interface UserRepository extends JpaRepository<UserAccount, Integer>, JpaSpecificationExecutor<UserAccount> {

    UserAccount findByAccount(String username);

    List<UserAccount> findByRolesIn(Collection<Role> roles);
    
    Page<UserAccount> findByRolesIn(Collection<Role> roles, Pageable pageable);

}
