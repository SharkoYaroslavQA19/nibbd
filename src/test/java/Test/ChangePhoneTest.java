package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ChangePhoneTest {
    private final static String ENDPOINT = "client/changePhone";

    @Test
    @Description("Запрос \"на перерегистрацию номера мобильного телефона физического лица по ПИНФЛ\" в НИББД")
    public void changeTestPhone() {
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(18313, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}