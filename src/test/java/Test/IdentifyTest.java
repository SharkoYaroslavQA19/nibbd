package Test;

import Model.Request;
import Model.RequestRegistr;
import Specification.Specification;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class IdentifyTest {
    protected Integer msgId;
    protected String actualResults= "10704: Error of the National information base of bank depositors (code 02718, text \"Физическое лицо с указанным удостоверяющим документом не зарегистрировано в НИББД\").";
    protected int StatusCodeOk = 200;
    protected int StatusCodeError = 422;

    @Test
    @Description("Идентификация физического лица по ПИНФЛ")
    public void identifyClientInNibddPinfl() {
        //Идентификация физического лица по ПИНФЛ
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17548, 1104);
        Response response = given()
                .body(request)
                .post("client/identify")
                .then()
                .extract()
                .response();
        msgId = response.path("msgId");
        Assert.assertEquals(StatusCodeOk, response.getStatusCode());

        //Регистрация клиента в БД по информации из ответа на запрос по идентификации клиента в НИББД
        RequestRegistr registr = new RequestRegistr(msgId);
        Response responseReg = (Response) given()
                .body(registr)
                .when()
                .post("client/registerClientInformation")
                .then()
                .extract();
        Assert.assertEquals(StatusCodeOk, responseReg.getStatusCode());
    }


    @Test
    @Description("Идентификация физического лица по ПИНФЛ")
    public void identifyClientInNibddDocuments() {
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(17688, 1104);
        Response response = given()
                .body(request)
                .post("client/identify")
                .then()
                .extract()
                .response();
        msgId = response.path("msgId");
        Assert.assertEquals(StatusCodeOk, response.getStatusCode());

        //Регистрация клиента в БД по информации из ответа на запрос по идентификации клиента в НИББД
        RequestRegistr registr = new RequestRegistr(msgId);
        Response responseReg = (Response) given()
                .body(registr)
                .when()
                .post("client/registerClientInformation")
                .then()
                .extract();
        Assert.assertEquals(StatusCodeOk, responseReg.getStatusCode());

    }

   /* @Test
    @Description("Идентификация физического лица по ПИНФЛ (клиент отсутствует в базе НИББД)")
    public void identifyClientInNibddDocumentsNegativeTest() {
        Specification.installSpecification(Specification.requestSpecification());
        Request request = new Request(386170, 1104);
        Response response = given()
                .body(request)
                .post("client/identify")
                .then()
                .extract()
                .response();
        String ExpectedResults = response.path("message");
        Assert.assertEquals(StatusCodeError, response.getStatusCode());
        Assert.assertEquals(ExpectedResults, actualResults);
    }

    */
}