package cn.com.wservice.mcproj.api.service;



import cn.com.wservice.mcproj.api.domain.Permission;
import cn.com.wservice.mcproj.api.domain.Role;

import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
public interface PermissionService {
    Set<Permission> getByRole(Set<Role> roles);
    Set<Permission> getAll();
    void createPermission(Permission permission);
    void  deletePermission(int id);
	void updatePermission(Permission permission);
}
