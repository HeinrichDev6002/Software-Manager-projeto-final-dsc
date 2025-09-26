package com.example.software_manager.Repository;

import com.example.software_manager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUserId(Long userId);
}
