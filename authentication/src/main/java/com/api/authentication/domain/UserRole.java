package com.api.authentication.domain;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    public String role;

    UserRole(String role){
        this.role = role;
    }
}
