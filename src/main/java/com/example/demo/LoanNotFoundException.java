package com.example.demo;

public class LoanNotFoundException extends Exception {

    private int loan_id;
    public LoanNotFoundException(int loan_id){
        super(String.format("User not found with id  %s ", loan_id));
    }
}
