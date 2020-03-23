package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="user_account")
public class UserAccount {

    @Id
    private int user_id;

    //@NotBlank
    private int account_id;


    public UserAccount(){
        super();
    }


    public UserAccount(int user_id, int account_id){
        super();
        this.user_id = user_id;
        this.account_id = account_id;
    }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getAccount_id() { return account_id; }

    public void setAccount_id(int account_id) { this.account_id = account_id; }



}
