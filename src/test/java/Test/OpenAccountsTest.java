package Test;

import Model.OpenAccount;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class OpenAccountsTest {
    private final static String ENDPOINT = "account/register";

    protected Integer CLIENTID = 17547;
    protected Integer BRANCHID = 1104;
    protected Integer PLANID = 20208;
    protected Integer CURRENCYID = 826;
    protected Integer NUMBERID = 3;


    @Test
    @Description("открытие лицевого счета ФЛ через НИББД")
    public void openAccountTest() {
        //открытие лицевого счета ФЛ через НИББД
        Specification.installSpecification(Specification.requestSpecification());
        OpenAccount openAccount = new OpenAccount(CLIENTID, BRANCHID, PLANID, CURRENCYID, NUMBERID);
        Response response = given()
                .body(openAccount)
                .post(ENDPOINT)
                .then()
                .extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }
}