package com.example.demo;

public class UserDetailsNotFoundException extends Exception {

    private int user_id;
    public UserDetailsNotFoundException(int user_id){
        super(String.format("User not found with id  %s", user_id));
    }
}
