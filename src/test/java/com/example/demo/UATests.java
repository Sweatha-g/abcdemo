package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class UATests {
    @Test
    void contextLoads() {
    }

    @Test
    public void testUserAccountList() {

        get("http://localhost:8080/ua")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(2));

        get("http://localhost:8080/ua/7")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(777));
    }
 /* @Test
    public void testUserAccountId() {
        get("http://localhost:8080/ua/7")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(777));
    }
*/
}

