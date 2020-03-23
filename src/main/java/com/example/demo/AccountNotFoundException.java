package com.example.demo;

public class AccountNotFoundException extends Exception  {

        private int account_id;
        public AccountNotFoundException(int account_id){
            super(String.format("User not found with id  %s", account_id));
        }

 }


