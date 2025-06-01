package com.aivle1_3.BookApi.repository;

import com.aivle1_3.BookApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserid(String userid);
}
