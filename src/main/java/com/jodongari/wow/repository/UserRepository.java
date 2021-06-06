package com.jodongari.wow.repository;

import com.jodongari.wow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
