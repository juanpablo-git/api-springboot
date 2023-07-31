package com.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInterface extends JpaRepository<User,Integer> {
    UserDetails findBylogin(String string);
}
