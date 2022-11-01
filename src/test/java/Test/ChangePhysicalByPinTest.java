package Test;

import Model.Request;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;



public class ChangePhysicalByPinTest {
    private final static String ENDPOINT = "client/changePhysicalByPin";

    @Test
    @Description("Запрос \"перерегистрацию физического лица с удостоверяющего документа на ПИНФЛ\" в НИББД")
    public void changeTestPinfl() {
        //Запрос "перерегистрацию физического лица с удостоверяющего документа на ПИНФЛ" в НИББД
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17978, 1104);
        Response response = given()
                .body(request)
                .when()
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}