package tests;

import Requests.UserRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest {
    private String email ="eve.holt@reqres.in";
    private String password = "pistol";

    private Response response = UserRequests.registerUser(email, password);

    @Test
    public void testStatusCodeIs200() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testResponseTimeIsLessThan500ms() {
        Assert.assertTrue(response.getTime() < 500);
    }

    @Test
    public void testIdPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("id"));
    }

    @Test
    public void testIdIsNumber() {
        Assert.assertTrue(response.jsonPath().get("id") instanceof Integer);
    }

    @Test
    public void testTokenPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("token"));
    }

    @Test
    public void testTokenIsString() {
        Assert.assertTrue(response.jsonPath().get("token") instanceof String);
    }

}
