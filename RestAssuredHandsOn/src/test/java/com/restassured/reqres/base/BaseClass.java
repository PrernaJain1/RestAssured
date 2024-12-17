package com.restassured.reqres.base;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;

public class BaseClass {

    @BeforeTest
    public void preCondition(){
        baseURI = "https://reqres.in/";
    }

}
