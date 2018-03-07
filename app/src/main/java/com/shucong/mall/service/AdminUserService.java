package com.shucong.mall.service;

import com.shucong.mall.bean.SysAdminRole;
import com.shucong.mall.bean.SysRolePermission;
import com.shucong.mall.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private AdminMapper adminMapper;

    public List<SysRolePermission> getPermissionSet(Long adminId){

        SysAdminRole sysAdminRole = adminMapper.findAdminRoleById(adminId);
        if (sysAdminRole == null) {
            return null;
        }

        return adminMapper.findRolePermissionByRoleId(sysAdminRole.getRoleId());
    }
}
