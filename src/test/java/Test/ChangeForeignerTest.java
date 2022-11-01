package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ChangeForeignerTest {
    private final static String ENDPOINT = "client/changeForeigner";

    @Test
    @Description("Запрос \"регистрацию изменений удостоверяющего документа иностранного гражданина\" в НИББД")
    public void changeTestForeigner() {
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17985, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}