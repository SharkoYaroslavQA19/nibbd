package Specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
    private final static String URL = "http://sc-compile:8080/integration-nibbd/";

    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }



    public static void installSpecification(RequestSpecification request){
        RestAssured.requestSpecification = request;
    }
}
