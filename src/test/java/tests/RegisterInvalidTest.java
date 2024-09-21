package tests;

import Requests.UserRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterInvalidTest {
    private Response response = UserRequests.registerUser("eve.holt@reqres.in", "");

    @Test
    public void testStatusCodeIs400() {
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void testResponseTimeIsLessThan500ms() {
        Assert.assertTrue(response.getTime() < 500);
    }

    @Test
    public void testErrorPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("error"));
    }

    @Test
    public void testErrorPropertyValueIsCorrect() {
        Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
    }
}
