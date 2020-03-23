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

public class AccountsTest {
    @Test
    void contextLoads() {
    }

    @Test
    public void testAccountList() {

        get("http://localhost:8080/accounts")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(2));

        get("http://localhost:8080/accounts/10")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_name", Matchers.equalTo("Johsu"));
    }
    @Test
    public void testAccountStatus() {

        get("http://localhost:8080/accounts/10")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_status", Matchers.equalTo("Open"));
    }
    @Test
    public void testAccountOpen() {

        get("http://localhost:8080/accounts/11")
                .then()
                .assertThat()
                .statusCode(200)
                .body("date_open", Matchers.equalTo("2011-12-10 00:00:00"));
    }
    @Test
    public void testMobileNumber() {

        get("http://localhost:8080/accounts/10")
                .then()
                .assertThat()
                .statusCode(200)
                .body("mobile_number", Matchers.equalTo("2382993336"));
    }


    @Test
    public void testDeleteAccounts() {

        delete("http://localhost:8080/accounts/10")
                .then()
                .assertThat()
                .statusCode(200).and().
                extract().
                response().asString();


    }
    @Test
    public void testPostAccount()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"account_id\":10,\"account_name\":\"Mrudula\",\"account_address\":\"224 ters street , Boston\"," +
                        "\"account_status\":\"closed\",\"email_id\":\"Mrd@gmail.com\"," +
                        "\"mobile_number\":\"2522889082\",\"account_type\":\"Checking\"," +
                        "\"date_open\":\"2011-12-10 00:00:00\",\"date_closed\":\"2019-06-02 00:00:00\"}").
                // body("bo").
                        when().
                        post("http://localhost:8080/accounts").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();
    }
    @Test
    public void testAccountPut()
    {
        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"account_id\":11,\"account_name\":\"Bhuvana\",\"account_address\":\"225 ters street , Boston\"," +
                        "\"account_status\":\"closed\",\"email_id\":\"bhuvi@gmail.com\"," +
                        "\"mobile_number\":\"2522889092\",\"account_type\":\"Checking\"," +
                        "\"date_open\":\"2011-12-11 00:00:00\",\"date_closed\":\"2019-06-02 00:00:00\"}").
                // body("bo").
                        when().
                        put("http://localhost:8080/accounts/11").
                        then().assertThat().
                        statusCode(200).
                        extract().
                        response().asString();

    }
}