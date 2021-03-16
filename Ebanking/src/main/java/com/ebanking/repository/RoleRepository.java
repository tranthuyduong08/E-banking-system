package com.ebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanking.entity.User;

public interface RoleRepository extends JpaRepository<User, Long> {

}
