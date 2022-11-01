package Test;

import io.qameta.allure.Description;
import io.restassured.response.Response;



import static io.restassured.RestAssured.*;

public class IdentifyClientInUEBTest {
    /*
String URL = "http://sc-compile:8080/integration-nibbd/";
    @Test
    @Description("")
    public void identifyClientInUEBTest() {
        //Отправка запроса

        JSONObject requestBody = new JSONObject()
                .put("clientId", 386235)
                .put("branchId", 1104);
        Response response = given()
                .body(requestBody.toString())
                .header("Content-Type", "application/json")
                .when()
                .post(URL+"client/identifyClientInUEB")
                .then()
                .extract().response();
        Integer msgId = response.path("msgId");
        Assert.assertEquals(200, response.getStatusCode());

        //Регистрация ответа от НИББД
        JSONObject requestBodyReg = new JSONObject(response)
                .put("msgId", msgId);
        Response responseREg = given()
                .body(requestBodyReg.toString())
                .header("Content-Type", "application/json")
                .when()
                .post(URL+"client/registerClientInformationFromUEB")
                .then()
                .extract().response();
            Assert.assertEquals(200, responseREg.getStatusCode());
    }

     */
}
