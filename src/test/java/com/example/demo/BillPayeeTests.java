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

public class BillPayeeTests {
    @Test
    void contextLoads() {
    }

    @Test
    public void testbillPayeeList() {

        get("http://localhost:8080/billpayees")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));

        get("http://localhost:8080/billpayees/333000")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user_id", Matchers.equalTo("722230"));
    }
    @Test
    public void testPhoneNo() {

        get("http://localhost:8080/billpayees/999999")
                .then()
                .assertThat()
                .statusCode(200)
                .body("payee_phone", Matchers.equalTo("3132999991"));
    }
    @Test
    public void testDeleteBillPayees() {

        delete("http://localhost:8080/billpayees/3226")
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
                body("{\"payee_id\":333223,\"payee_account_no\":\"6622324\",\"user_id\":\"822230\",\"payee_phone\":\"3132323291\",\"payee_address\":\"17 green st Kentucky\"}").
                // body("bo").
                        when().
                        post("http://localhost:8080/billpayees").
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
                body("{\"payee_id\":999999,\"payee_account_no\":\"877825\",\"user_id\":\"722370\",\"payee_phone\":\"3132423291\",\"payee_address\":\"20 New st Kentucky\"}").
                // body("bo").
                        when().
                        put("http://localhost:8080/billpayees/999999").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();

    }
    }



