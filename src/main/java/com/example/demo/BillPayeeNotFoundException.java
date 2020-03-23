package com.example.demo;

public class BillPayeeNotFoundException extends Exception {

        private int payee_id;
        public BillPayeeNotFoundException (int payee_id ){
            super(String.format("Employee not found with id  %s", payee_id));
        }
    }


