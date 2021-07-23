package tests.webServicesTests.jsonPlaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTestForWebServices;

public class ResponseHeaderForGetRequestTest extends BaseTestForWebServices {

    @Test
    public void checkContentTypeHeader() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();

        logger.info(String.format("Content-Type Header of the response for current request is: %s", response.getHeader("Content-Type")));

        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8", "Wrong Content-Type Header");
    }
}