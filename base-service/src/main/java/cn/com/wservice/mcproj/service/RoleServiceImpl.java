package cn.com.wservice.mcproj.service;


import cn.com.wservice.mcproj.api.domain.Permission;
import cn.com.wservice.mcproj.api.domain.Role;
import cn.com.wservice.mcproj.api.service.RoleService;
import cn.com.wservice.mcproj.repository.PermissionRepository;
import cn.com.wservice.mcproj.repository.RoleRepository;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zhangz on 2017/7/24.
 */
@Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {

    private @Resource
    RoleRepository roleRepository;
    private @Resource
    PermissionRepository permissionRepository;

    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(role -> roles.add(role));
        return roles;
    }

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void createRole(Role role, Set<Integer> permIds, Set<Integer> menuIds) {
        if (null != permIds) {
            Set<Permission> permissions = permIds.stream().map(id -> {
                return permissionRepository.findOne(id);
            }).collect(Collectors.toSet());
            role.getPermissions().addAll(permissions);
        }
        roleRepository.save(role);
    }


    @Override
    public Role findById(Integer id) {
        return this.roleRepository.findOne(id);
    }

    @Override
    public void update(Role role, Set<Integer> permIds, Set<Integer> menuIds) {
        if (null != permIds) {
            Set<Permission> permissions = permIds.stream().map(id -> {
                return permissionRepository.findOne(id);
            }).collect(Collectors.toSet());
            role.setPermissions(permissions);
        }

        roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.delete(id);
    }
}
