package com.testspring.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testspring.springtest.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {
   
}
