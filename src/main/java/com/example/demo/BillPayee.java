package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="bill_payee")
public class BillPayee {


    @Id
    private int payee_id;

    @NotBlank
    private String payee_account_no;

    @NotBlank
    private String user_id;

    @NotBlank
    private String payee_phone ;

    @NotBlank
    private String payee_address;


    public BillPayee(){
        super();
    }


    public BillPayee(int payee_id, String user_id, String payee_account_no, String payee_phone, String payee_address) {
        super();
        this.payee_id = payee_id;
        this.user_id = user_id;
        this.payee_account_no = payee_account_no;
        this.payee_phone= payee_phone;
        this. payee_address =  payee_address;

    }

    public int getPayee_id() {
        return payee_id;
    }
    public void setPayee_id(int payee_id) {
        this.payee_id = payee_id;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPayee_account_no() {
        return payee_account_no;
    }
    public void setPayee_account_no(String payee_account_no) {
        this.payee_account_no = payee_account_no;
    }

    public String getPayee_phone() {
        return payee_phone;
    }
    public void setPayee_phone(String payee_phone) {
        this.payee_phone = payee_phone;
    }

    public String getPayee_address() {
        return payee_address;
    }
    public void setPayee_address(String payee_address) {
        this.payee_address = payee_address;
    }





}
