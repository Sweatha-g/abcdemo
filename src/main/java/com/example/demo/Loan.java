package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="loan")
public class Loan {

    @Id
    private int loan_id;


    @NotBlank
    private String loan_type;
    private String loan_amount;

    private String user_id;
    private String account_id;

    @NotBlank
    private String loan_open_date;

    @NotBlank
    private String loan_status;

    @NotBlank
    private String loan_term;



    public Loan(){
        super();
    }


    public Loan(int loan_id, String user_id, String account_id, String loan_type, String loan_amount, String loan_open_date, String loan_status, String loan_term) {
        super();
        this.loan_id = loan_id;
        this.user_id= user_id;
        this.account_id= account_id;
        this.loan_type= loan_type;
        this.loan_amount= loan_amount;
        this.loan_open_date= loan_open_date;
        this.loan_status = loan_status;
        this.loan_term = loan_term;
    }
    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getLoan_open_date() {
        return loan_open_date;
    }

    public void setLoan_open_date(String loan_open_date) {
        this.loan_open_date = loan_open_date;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public String getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(String loan_term) {
        this.loan_term = loan_term;
    }








}
