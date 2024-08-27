package com.caffainbst.caffainbooster_20.dao;

import com.caffainbst.caffainbooster_20.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
