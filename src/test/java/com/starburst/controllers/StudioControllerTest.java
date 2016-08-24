package com.starburst.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //tells test server to use the right port
@Sql(value = "/prepare-db.sql")
public class StudioControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    //GET /api/studios
    public void shouldShowAllStudiosOnPage0() throws Exception {
        given().log().all().and().given()
                .get("/api/studios")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(3),
                        "totalPages", is(2),
                        "content[0].name", equalTo("MGM"),
                        "content[0].id", is(1),
                        "content[0].version", is(0)


                );

    }

    @Test
    //GET /api/studios
    public void shouldShowAllStudiosOnPage1() throws Exception {
        given().log().all().and().given()
                .get("/api/studios?page=1")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(2),
                        "totalPages", is(2),
                        "content[0].name", equalTo("WB"),
                        "content[0].id", is(4),
                        "content[0].version", is(0)
                );
    }

    @Test
    //POST /api/studios
    public void shouldCreateAStudio() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Sony");
        json.put("est", "1985-01-16");

        given().log().all().and().given()
                .contentType(ContentType.JSON)
                .body(json)
                .post("/api/studios")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Sony"),
                        "id", is(6),
                        "version", is(0)
                );
    }

    @Test
    // DELETE /api/studios/:id
    public void shouldDeleteStudio() throws Exception {
        given().log().all().and().given().
                delete("/api/studios/3")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    // PUT /api/studios/:id
    public void shouldUpdateStudio() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "MGM 1");
        json.put("est", "2001-01-05");

        given().log().all().and().given().
                contentType(ContentType.JSON). // data being passed in
                body(json).
                put("/api/studios/1")
                .then().log().all()
                .statusCode(200)
                .body(                          // assertions
                        "name", equalTo("MGM 1"),
                        "version", is(1),
                        "est", is(978652800000L)
                );
    }

}