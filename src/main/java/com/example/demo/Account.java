package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name ="account")
public class Account {


        @Id
        private int account_id;

        @NotBlank
        private String account_name;
        private String account_address;

        @NotBlank
        private String account_status ;

        @Email
        @NotBlank
        private String email_id;

        @NotBlank
        private String mobile_number;

        @NotBlank
        private String account_type;

        @NotNull
        private String   date_open;
        private String  date_closed;

        public Account(){
            super();
        }


    public Account(int account_id, String account_name, String account_address, String account_status, String email_id, String mobile_number, String account_type, String date_open, String date_closed) {
            super();
            this.account_id = account_id;
            this.account_name = account_name;
            this.account_address = account_address;
            this.account_status = account_status;
            this.email_id = email_id;
            this.mobile_number = mobile_number;
            this.account_type= account_type;
            this.date_open = date_open;
            this.date_closed = date_closed;
        }



    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_address() {
        return account_address;
    }

    public void setAccount_address(String account_address) {
        this.account_address = account_address;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getDate_open() {
        return date_open;
    }

    public void setDate_open(String date_open) {
        this.date_open = date_open;
    }

    public String getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(String date_closed) {
        this.date_closed = date_closed;
    }


}



