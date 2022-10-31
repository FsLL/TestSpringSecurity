package com.lqj.config;

import com.lqj.dto.LoginUser;
import com.lqj.entity.User;
import com.lqj.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lqj
 * @Date 2022-10-26 13:27
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if(principal != null && principal instanceof UserDetails){
            User user = ((LoginUser) principal).getUser();
            List<String> permissions = menuMapper.selectPermsByUserId(user.getId());
            if (permissions.contains(permission.toString())){
                return true;
            }
        }
        return hasPermission;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
