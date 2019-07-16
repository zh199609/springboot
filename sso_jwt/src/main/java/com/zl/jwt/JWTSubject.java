package com.zl.jwt;

public class JWTSubject {
    private String username;

    public JWTSubject(String username) {
        this.username = username;
    }

    public JWTSubject() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
