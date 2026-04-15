package com.mobileprepaid.backend.Repository;

import com.mobileprepaid.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);
}