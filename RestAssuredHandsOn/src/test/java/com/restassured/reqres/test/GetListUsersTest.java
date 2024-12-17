package com.restassured.reqres.test;

import com.restassured.reqres.base.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class GetListUsersTest extends BaseClass {


    @Test
    public void getListUsers(){
        Response response =given()
                .get("api/users?page=2");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void validateGetListUsers() throws FileNotFoundException {
        given()
                .get("api/users?page=2")
        .then()
                .assertThat().body(matchesJsonSchema(new FileInputStream("src/test/resources/jsonSchemaGet.json")))
                .body("data[1].first_name",equalTo("Lindsay"));
    }

    @Test
    public void validateMultipleArrayData(){
        given()
                .get("api/users?page=2")
        .then()
                .body("data.first_name",hasItems("Michael","Lindsay","Tobias"))
                .statusCode(200)
                .log().all();
    }
}
