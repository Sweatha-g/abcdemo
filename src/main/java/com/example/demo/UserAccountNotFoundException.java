package com.example.demo;

public class UserAccountNotFoundException extends Exception {

    private int user_id;
    public UserAccountNotFoundException(int user_id){
        super(String.format("User not found with id  %s", user_id));
    }
}
