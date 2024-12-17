package com.restassured.reqres.test;

import com.restassured.reqres.base.BaseClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete extends BaseClass {

    @Test
    public void deleteUser(){
        given()
                .log().all()
        .when()
                .delete("/api/users/2")
        .then()
                .statusCode(204)
                .log().all();
    }
}
