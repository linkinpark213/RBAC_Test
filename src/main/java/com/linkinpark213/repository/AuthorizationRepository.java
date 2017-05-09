package com.linkinpark213.repository;

import com.linkinpark213.model.AuthorizationEntity;
import com.linkinpark213.model.PermissionEntity;
import com.linkinpark213.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ooo on 2017/5/10 0010.
 */
public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, Integer> {
    public AuthorizationEntity findByRoleByRoleIdAndPermissionByPermissionId(RoleEntity roleEntity, PermissionEntity permissionEntity);
}
