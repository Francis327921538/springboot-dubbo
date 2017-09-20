package cn.com.wservice.mcproj.repository;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangz on 2017/9/15.
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
}
