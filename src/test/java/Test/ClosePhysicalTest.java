package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ClosePhysicalTest {
    private final static String ENDPOINT = "client/closePhysical";

    @Test
    @Description("Регистрация прекращения деятельности клиента ФЛ в НИББД")
    public void closePhysicalTest() {
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17973, 1104);
        Response response = given()
                .body(request).log().all()
                .when()
                .post(ENDPOINT)
                .then().log().all()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}