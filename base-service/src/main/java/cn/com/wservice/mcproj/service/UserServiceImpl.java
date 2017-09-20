package cn.com.wservice.mcproj.service;


import cn.com.wservice.mcproj.api.domain.UserAccount;
import cn.com.wservice.mcproj.api.service.UserService;
import cn.com.wservice.mcproj.repository.RoleRepository;
import cn.com.wservice.mcproj.repository.UserRepository;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zhangz on 2017/7/18.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    private @Resource
    UserRepository userRepository;
    private @Resource
    RoleRepository roleRepository;
    private @Resource
    PasswordHelper passwordHelper;

    @Override
    public UserAccount getByUsername(String username) {
        return userRepository.findByAccount(username);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserAccount> getAll() {
        List<UserAccount> userAccounts = new ArrayList<>();
        userRepository.findAll().forEach(in -> userAccounts.add(in));
        return userAccounts;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        passwordHelper.encryptPassword(user);
        if (null != user.getUserDetail()) {
            user.getUserDetail().setUserAccount(user);
        }

        if (null != user.getRoles()) {
            user.setRoles(user.getRoles());
        }
        return userRepository.save(user);
    }

    @Override
    public void updateUser(UserAccount user) {
        passwordHelper.encryptPassword(user);
        if (null != user.getUserDetail()) {
            user.getUserDetail().setId(user.getId());
            user.getUserDetail().setUserAccount(user);
        }

        if (null != user.getRoles()) {
            user.setRoles(user.getRoles());
        }

        userRepository.saveAndFlush(user);
    }

    @Override
    public Page<UserAccount> getSearchPage(UserAccount queryUser, Pageable pageable) {
        return userRepository.findAll(
                new Specification<UserAccount>() {
                    @Override
                    public Predicate toPredicate(Root<UserAccount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        Predicate predicate = criteriaBuilder.or(
                                criteriaBuilder.like(root.get("account"), "%" + queryUser.getAccount() + "%"),
                                criteriaBuilder.like(root.get("email"), "%" + queryUser.getEmail() + "%"),
                                criteriaBuilder.like(root.get("userDetail").get("username"), "%" + queryUser.getUserDetail().getUsername() + "%"),
                                criteriaBuilder.like(root.get("userDetail").get("phone"), "%" + queryUser.getUserDetail().getPhone() + "%")
                        );
                        return queryUser.getState() == 0 ?
                                criteriaBuilder.and(
                                        criteriaBuilder.equal(root.get("userDetail").get("gender"), queryUser.getUserDetail().getGender()),
                                        predicate)
                                :
                                criteriaBuilder.and(
                                        criteriaBuilder.equal(root.get("state"), queryUser.getState()),
                                        criteriaBuilder.equal(root.get("userDetail").get("gender"), queryUser.getUserDetail().getGender()),
                                        predicate);

                    }
                }, pageable);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set = set.stream().map(s -> {
            return s += "asas";
        }).collect(Collectors.toSet());
        System.out.println(set);
    }

    @Override
    public UserAccount getUser(Integer id) {
        return userRepository.findOne(id);
    }
}
