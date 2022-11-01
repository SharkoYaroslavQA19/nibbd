package Test;

import Model.CloseAccount;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class CloseAccountTest {
    private final static String ENDPOINT = "account/close";


    @Test
    @Description("Закрытие лицевого счета ФЛ через НИББД")
    public void closeAccountTest() {
        //Закрытие лицевого счета ФЛ через НИББД
        Specification.installSpecification(Specification.requestSpecification());
        CloseAccount closeAccount = new CloseAccount(224886,1104,"2022-07-26");
        Response response = given()
                .body(closeAccount)
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());

    }
}