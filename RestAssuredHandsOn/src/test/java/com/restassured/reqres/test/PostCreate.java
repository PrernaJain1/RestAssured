package com.restassured.reqres.test;

import com.restassured.reqres.base.BaseClass;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class PostCreate extends BaseClass {

    @Test
    public void createUser() throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "lead");

        given()
           .header("Content-Type", "application/json")
           .body(jsonObject.toJSONString())
        .when()
            .post("/api/users")
        .then()
            .assertThat().body(matchesJsonSchema(new FileInputStream("src/test/resources/jsonSchemaPost.json")))
            .statusCode(201);
//            .extract().body().jsonPath().toString();

//        System.out.println(response);
    }
}
