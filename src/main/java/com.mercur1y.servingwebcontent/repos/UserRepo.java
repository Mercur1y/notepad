package com.mercur1y.servingwebcontent.repos;

import com.mercur1y.servingwebcontent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

    Boolean existsByEmail(String email);
}
