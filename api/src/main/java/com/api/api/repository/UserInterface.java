package com.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserInterface extends JpaRepository<User,Integer> {
    UserDetails findByLogin(String login);
}
