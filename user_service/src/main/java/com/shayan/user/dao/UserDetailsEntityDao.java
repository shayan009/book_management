package com.shayan.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shayan.user.entity.UserModel;


@Repository
public interface UserDetailsEntityDao extends JpaRepository<UserModel, Integer> {


}
