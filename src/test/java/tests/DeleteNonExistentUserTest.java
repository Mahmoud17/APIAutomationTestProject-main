package tests;

import Requests.UserRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNonExistentUserTest {
    Response response = UserRequests.deleteUser(2);
    @Test
    public void testStatusCodeIs204NoContent() {
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void testResponseTimeIsLessThan500ms() {
        Assert.assertTrue(response.getTime() < 500);
    }
}
