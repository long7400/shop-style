package com.shopstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopstyle.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name, int status);
}