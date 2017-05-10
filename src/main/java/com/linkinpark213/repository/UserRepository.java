package com.linkinpark213.repository;

import com.linkinpark213.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ooo on 2017/5/10 0010.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
