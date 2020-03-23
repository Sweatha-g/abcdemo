package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class AccountTransTest {
    @Test
    void contextLoads() {
    }

    @Test
    public void testAccountTransList() {

        get("http://localhost:8080/accountstransaction")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));

        get("http://localhost:8080/accountstransaction/23")
                .then()
                .assertThat()
                .statusCode(200)
                .body("transaction_no", Matchers.equalTo("223"));
    }
    @Test
    public void testTransType() {

        get("http://localhost:8080/accountstransaction/20")
                .then()
                .assertThat()
                .statusCode(200)
                .body("transaction_type", Matchers.equalTo("P"));
    }
    @Test
    public void testLoanId() {

        get("http://localhost:8080/accountstransaction/23")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_id", Matchers.equalTo("4"));
    }
    @Test
    public void testTransAmount() {

        get("http://localhost:8080/accountstransaction/23")
                .then()
                .assertThat()
                .statusCode(200)
                .body("transaction_amount", Matchers.equalTo(130f));
       // body("value", Matchers.equalTo(new Double(someJavaDouble)))
    }
    @Test
    public void testDeleteAccountsTrans() {

        delete("http://localhost:8080/accountstransaction/3")
                .then()
                .assertThat()
                .statusCode(200).and().
                extract().
                response().asString();


    }
    @Test
    public void testPostAccountTrans()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"account_id\":21,\"transaction_no\":\"2210\",\"transaction_date\":\"2016-02-19 00:00:00\",\"transaction_amount\":140.0,\"account_balance\":0.0,\"transaction_type\":\"CR\",\"loan_id\":\"5\",\"payee_id\":\"12\"}").
                // body("bo").
                        when().
                        post("http://localhost:8080/accountstransaction").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();
    }
    @Test
    public void testPutAcctTrans()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
        body("{\"account_id\":20,\"transaction_no\":\"2200\",\"transaction_date\":\"2011-12-10 00:00:00\",\"transaction_amount\":450.0,\"transaction_type\":\"P\",\"loan_id\":\"34\",\"payee_id\":\"7\",\"account_balance\":0.0}").
                        when().
                        put("http://localhost:8080/accountstransaction/20").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();

    }

}
