package tests.webServicesTests.jsonPlaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.userObject.UserObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTestForWebServices;

public class ResponseBodyForGetRequestTest extends BaseTestForWebServices {

    @Test
    public void checkResponseBody() {
        Response reponse = RestAssured.when()
                .get("/users")

                .andReturn();
        ResponseBody<?> responseBody = reponse.getBody();
        UserObject[] users = responseBody.as(UserObject[].class);

        logger.info(String.format("The quantity of 'User' objects is: %s", users.length));

        Assert.assertEquals(users.length, 10, "Incorrect number of objects");
    }
}