package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class RegisterTest {
    private final static String ENDPOINT = "client/register";

    @Test
    @Description("Запрос Регистрация ФЛ по ПИНФЛ в НИББД")
    public void registerTestNibbdPinfl() {
        //Запрос "Регистрация ФЛ по ПИНФЛ" в НИББД
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17714, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Description("Запрос Регистрация ФЛ по УД резидент в НИББД")
    public void registerTestNibbdResident() {
        //Запрос "Регистрация ФЛ по УД резидент" в НИББД
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17754, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Description("Запрос Регистрация ФЛ по УД нерезидент в НИББД")
    public void registerTestNibbdNotResident() {
        //Запрос "Регистрация ФЛ по УД нерезидент" в НИББД
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17949, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }

}
