package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name ="account_transaction")
public class Accounttransaction {

    @Id
    private int account_id;

    @NotBlank
    private String transaction_no;

   // @NotBlank
    private String transaction_date;

   // @NotBlank
    private double transaction_amount;

    @NotBlank
    private double account_balance;

    @NotBlank
    private String transaction_type;

    @NotNull
    private String loan_id;
    @NotBlank
    private String payee_id;

    public Accounttransaction(){
        super();
    }


    public Accounttransaction(int account_id, String transaction_no, String  transaction_date, double transaction_amount, String transaction_type, String loan_id, String payee_id, double account_balance) {
        super();
        this.account_id = account_id;
        this.transaction_no = transaction_no;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
        this. loan_id =  loan_id;
        this.payee_id = payee_id;
        this.account_balance = account_balance;
    }


    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
    }

    public double getAccount_balance() { return account_balance; }

    public void setAccount_balance(double account_balance) { this.account_balance = account_balance; }

//new code
 //   public double getAccount_balance() { return account_balance; }

 //   public void setAccount_balance(double account_balance ) {this.account_balance = account_balance ; }

   /* public double actblnc(double account_balance, String transaction_type, double transaction_amount){
        if(transaction_type == "CR"){
            account_balance = account_balance - transaction_amount ;
        }
        return account_balance;
    } */



}
