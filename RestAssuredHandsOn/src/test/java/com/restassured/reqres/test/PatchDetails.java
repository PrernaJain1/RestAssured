package com.restassured.reqres.test;

import com.restassured.reqres.base.BaseClass;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchDetails extends BaseClass {

    @Test
    public void patchDetails(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","zion resident");

        given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
        .when()
                .patch("/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }
}
