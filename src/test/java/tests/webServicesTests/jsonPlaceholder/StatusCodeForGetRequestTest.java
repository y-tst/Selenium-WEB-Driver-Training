package tests.webServicesTests.jsonPlaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTestForWebServices;

public class StatusCodeForGetRequestTest extends BaseTestForWebServices {

    @Test
    public void checkStatusCode() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();

        logger.info(String.format("Status line of the response for current request is: %s", response.getStatusLine()));

        Assert.assertEquals(response.getStatusCode(), 200, "Unexpected Status code for current request");
    }
}