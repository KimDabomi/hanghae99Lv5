package org.sparta.hanghae99lv5.repository;

import org.sparta.hanghae99lv5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}