package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoRestCRUD {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;
    static int createdPostId;

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Custom-Header", "RestAssuredDemo")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    @AfterAll
    static void tearDown(){
        RestAssured.reset();
    }

    @Test
    public void getPost(){
        given()
                .spec(requestSpec)
                .when()
                .get("/posts/1")
                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test
    @Order(1)
    @DisplayName("CREATE - POST new post")
    void create_post_returnsCreatedResource() {
        // Request body as JSON string
        String requestBody = """
            {
                "title": "Test Post from REST Assured",
                "body": "This post was created during our demo",
                "userId": 1
            }
            """;

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  // Created
                .body("title", equalTo("Test Post from REST Assured"))
                .body("body", containsString("demo"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        // Store ID for later tests
        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    @Test
    @Order(2)
    @DisplayName("Create - Post with Java Object")
    public void testSerialObject(){

        record Post(String title, String body, int userId){}
        Post newPost = new Post("POJO Test", "Testing a POJO Object", 1);

        Response response = given()
                .spec(requestSpec)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  // Created
                .body("title", equalTo("POJO Test"))
                .body("body", containsString("Testing a POJO Object"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        // Store ID for later tests
        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    @Test
    public void testParameterizedGET(){

        given()
                .spec(requestSpec)
                .when()
                .get("/posts/" + createdPostId)
                .then()
                .statusCode(201)  // Created
                .body("title", equalTo("POJO Test"))
                .body("body", containsString("Testing a POJO Object"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }

    @ParameterizedTest(name = "{0} /posts/{2} returns {3}")
    @CsvSource({
            "GET, /posts, 1, 200",
            "GET, /posts, 100, 200",
            "GET, /posts, 999, 404",
            "DELETE, /posts, 1, 200",


    })
    @DisplayName("Various HTTP operations")
    void httpOperations_variousVases(String method, String endpoint, int id, int expectedStatus){
        given().contentType(ContentType.JSON)
                .when()
                .request(method, endpoint + "/" + id)
                .then()
                .statusCode(expectedStatus);
    }
}
