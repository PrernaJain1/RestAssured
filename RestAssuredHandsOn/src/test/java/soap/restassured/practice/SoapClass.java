package soap.restassured.practice;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import static io.restassured.RestAssured.*;

public class SoapClass {

    @BeforeTest
    public void preRequisites(){
        baseURI ="http://www.dneonline.com";
    }

    @Test
    public void soapAdd(){
        try{
            File file = new File(System.getProperty("user.dir")+"//src//test//resources//add.xml");
            FileInputStream fileInputStream = new FileInputStream(file);

            String bdy = IOUtils.toString(fileInputStream,"UTF-8");

            given()
                    .header("ContentType","text/xml")
                    .contentType("text/xml").accept(ContentType.XML)
                    .body(bdy)
            .when()
                    .post("/calculator.asmx")
            .then()
                    .statusCode(200)
                    .log().all();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
