package tests;
import Requests.UserRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    private String name = "morpheus";
    private String job = "Leutinant";

    private Response response = UserRequests.createUser(name, job);

    @Test
    public void testStatusCodeIs201() {
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void testResponseTimeIsLessThan500ms() {
        Assert.assertTrue(response.getTime() < 500);
    }

    @Test
    public void testNamePropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("name"));
    }

    @Test
    public void testNameIsString() {
        Assert.assertTrue(response.jsonPath().get("name") instanceof String);
    }

    @Test
    public void testNameIsSameAsSent() {
        // Assuming 'request.name' is accessible
        Assert.assertEquals(response.jsonPath().getString("name"), name);
    }

    @Test
    public void testJobPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("job"));
    }

    @Test
    public void testJobIsString() {
        Assert.assertTrue(response.jsonPath().get("job") instanceof String);
    }

    @Test
    public void testJobIsSameAsSent() {
        // Assuming 'request.job' is accessible
        Assert.assertEquals(response.jsonPath().getString("job"), job);
    }

    @Test
    public void testIdPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("id"));
    }

    @Test
    public void testIdIsString() {
        Assert.assertTrue(response.jsonPath().get("id") instanceof String);
    }

    @Test
    public void testCreatedAtPropertyExists() {
        Assert.assertNotNull(response.jsonPath().get("createdAt"));
    }

    @Test
    public void testCreatedAtIsString() {
        Assert.assertTrue(response.jsonPath().get("createdAt") instanceof String);
    }
}
