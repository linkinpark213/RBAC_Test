package com.linkinpark213.repository;

import com.linkinpark213.model.RoleEntity;
import com.linkinpark213.model.UserEntity;
import com.linkinpark213.model.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ooo on 2017/5/8 0008.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    public List<UserRoleEntity> findByUserByUserid(UserEntity userEntity);
}
