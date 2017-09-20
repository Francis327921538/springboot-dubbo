package cn.com.wservice.mcproj.api.service;

import cn.com.wservice.mcproj.api.domain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhangz on 2017/9/15.
 */
public interface UserService {

    UserAccount getByUsername(String username);
    UserAccount getUser(Integer id);
    List<UserAccount> getAll();
    UserAccount createUser(UserAccount user);
    void deleteUser(int id);
    void updateUser(UserAccount user);
    Page<UserAccount> getSearchPage(UserAccount queryUser, Pageable pageable);
}
