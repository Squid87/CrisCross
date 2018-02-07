package com.example.tie.criscros.authorization;


public class AuthorizationBody {
    private String username;
    private String password;

    public void setLogin(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
