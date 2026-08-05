package com.findeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findeye.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}