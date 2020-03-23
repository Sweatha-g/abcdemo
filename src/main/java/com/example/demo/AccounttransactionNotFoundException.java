package com.example.demo;

public class AccounttransactionNotFoundException extends Exception {


        private int account_id;
        public AccounttransactionNotFoundException(int account_id){
            super(String.format("User not found with id  %s", account_id));
        }
}

