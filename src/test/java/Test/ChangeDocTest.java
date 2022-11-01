package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ChangeDocTest {
    private final static String ENDPOINT = "client/changeDoc";

    @Test
    @Description("Запрос регистрацию изменения удостоверяющего документа гражданина РУз в НИББД")
    public void changeTestDoc() {
        //Запрос " регистрацию изменения удостоверяющего документа гражданина РУз" в НИББД
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(352914, 1104);
        Response response = given()
                .body(request).log().all()
                .when()
                .post(ENDPOINT)
                .then().log().all()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}