package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import org.testng.Assert;
//import org.testng.annotations.Test;
import io.restassured.RestAssured;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testCustomerList() {

      /*  get("http://localhost:8080/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(8));*/

        get("http://localhost:8080/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user_id", Matchers.equalTo(2));

        get("http://localhost:8080/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("first_name", Matchers.equalTo("Bhuvana"));
    }

    @Test
    public void testMiddleName() {
        get("http://localhost:8080/users/7")
                .then()
                .assertThat()
                .statusCode(200)
                .body("middle_name", Matchers.equalTo("Jyeeiibee"));
    }
    @Test
    public void testEmail() {
        get("http://localhost:8080/users/5")
                .then()
                .assertThat()
                .statusCode(200)
                .body("email", Matchers.equalTo("Srisha291@gmail.com"));
    }
    @Test
    public void testPassword() {
        get("http://localhost:8080/users/8")
                .then()
                .assertThat()
                .statusCode(200)
                .body("password", Matchers.equalTo("abc8"));
    }

    @Test
    public void testDelete() {

        delete("http://localhost:8080/users/2227")
                .then()
                .assertThat()
                .statusCode(200).and().
                extract().
                response().asString();
                //.body("password", Matchers.equalTo("abc8"));

    }
    @Test
    public void RegisterUserPostUsers()
    {


        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"user_id\":12,\"first_name\":\"Sudiksha\",\"middle_name\":\"R\",\"last_name\":\"M\",\"email\":\"Deeksha@gmail.com\",\"mobile_number\":\"2522889082\",\"address\":\"224 ters street , Boston\",\"password\":\"Deeksha7235\"}").
                       // body("bo").
                when().
                post("http://localhost:8080/users").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();


    }
    @Test
    public void RegisterUserPutUsers()
    {

        //RestAssured.baseURI="http://localhost:8080";

        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"user_id\":2,\"first_name\":\"Bhuvana\",\"middle_name\":\"R\",\"last_name\":\"G\",\"email\":\"Bhuvi@gmail.com\",\"mobile_number\":\"2122889091\",\"address\":\"226 Green street , Michigan\",\"password\":\"Bhuvi@723\"}").
                // body("bo").
                        when().
                        put("http://localhost:8080/users/2").
                        then().assertThat().
                        statusCode(200).
                //header("content-length", "51").
                        extract().
                        response().asString();
       /*String bo=" '   {  '  + \r\n" +
                "'   \"user_id\": 7  '  + \r\n" +
                " '       \"first_name\": \"swea\",  '  + \r\n" +
                " '       \"middle_name\": \"R\",  '  + \r\n" +
                " '       \"last_name\": \"Gundu\",  '  + \r\n" +
                " '       \"email\": \"swea@gmail.com\",  '  + \r\n" +
                " '       \"mobile_number\": \"2489877781\",  '  + \r\n" +
                " '       \"address\": \"GreenHill rd, michigan\",  '  + \r\n" +
                " '       \"password\": \"leader\"  '  + \r\n" +
                " '  }  ' ; ";*/


    }
}
