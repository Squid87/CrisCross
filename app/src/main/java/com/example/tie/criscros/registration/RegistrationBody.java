package com.example.tie.criscros.registration;


public class RegistrationBody {
    private String username;
    private String password;
    private String email;

    public void setLogin(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String email) {
        this.email = email;
    }
}
