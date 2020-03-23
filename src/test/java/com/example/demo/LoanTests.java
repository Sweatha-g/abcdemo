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

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)

public class LoanTests {
    @Test
    void contextLoads() {
    }

    @Test
    public void testLoanList() {

        get("http://localhost:8080/loans")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(4));

        get("http://localhost:8080/loans/66")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user_id", Matchers.equalTo("6"));
    }
    @Test
    public void testLoanAmount() {

        get("http://localhost:8080/loans/67")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_amount", Matchers.equalTo("5000"));
    }
    @Test
    public void testLoanOpenDate() {

        get("http://localhost:8080/loans/68")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_open_date", Matchers.equalTo("2011-02-12 00:00:00"));
    }
    @Test
    public void testAccountID() {

        get("http://localhost:8080/loans/69998")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo("232222"));
    }
    @Test
    public void testDeleteLoans() {

        delete("http://localhost:8080/loans/68")
                .then()
                .assertThat()
                .statusCode(200).and().
                extract().
                response().asString();


    }
    @Test
    public void testPostBillPayee()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"loan_id\":68,\"loan_type\":\"Car\",\"loan_amount\":\"15000\",\"user_id\":\"10\",\"account_id\":\"11\",\"loan_open_date\":\"2011-04-12 00:00:00\",\"loan_status\":\"Open\",\"loan_term\":\"12 months\"}").
                // body("bo").
                        when().
                        post("http://localhost:8080/loans").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();
    }
    @Test
    public void testPutBillPayee()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"loan_id\":67,\"loan_type\":\"Personal\",\"loan_amount\":\"5000\",\"user_id\":\"10\",\"account_id\":\"10\",\"loan_open_date\":\"2016-02-02 00:00:00\",\"loan_status\":\"Open\",\"loan_term\":\"12 months\"}").
                // body("bo").
                        when().
                        put("http://localhost:8080/loans/67").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();

    }
}
