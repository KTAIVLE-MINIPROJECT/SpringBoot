package com.aivle1_3.BookApi.repository;

import com.aivle1_3.BookApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userid);

}
