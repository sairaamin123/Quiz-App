package com.example.quiz_app.Models;

public class User {
    public String email,password;
    // Constructors
    public User(){
    }
    public User(String email, String password){
        this.email = email;
        this.password =  password;
    }
}