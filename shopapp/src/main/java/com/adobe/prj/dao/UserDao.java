package com.adobe.prj.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
    // Since email is unique, we'll find users by email
    Optional<User> findByEmail(String email);
}
