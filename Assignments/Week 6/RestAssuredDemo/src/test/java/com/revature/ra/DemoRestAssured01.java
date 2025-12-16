package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoRestAssured01 {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    }

    @AfterAll
    static void tearDown(){
        RestAssured.reset();
    }

    @Test
    public void firstRequest(){

        given()
                .log().all()
        .when()
                .get("/posts/1")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testWithMoreDetails(){
        given()
                .log().parameters()
                .queryParam("userId", 1)
        .when()
                .get("/posts") // Posts?userId=1
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()",greaterThan(0));
    }

    @Test
    public void testUsers1(){
        given()
                .log().parameters()
        .when()
                .get("/users/1")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"))
                //.body("email",hasToString("@"))
                .body("address.city", equalTo("Gwenborough"))
                .body("address.geo.lat", equalTo("-37.3159"));
    }
}
