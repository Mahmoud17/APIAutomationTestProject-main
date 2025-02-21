package Requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class UserRequests {

    public static Response getAllUsers() {
        return RestAssured.given().log().all()
                .get(Constants.baseURL + Constants.userEndPoint);
    }

    public static Response getSingleUser(String id) {
        return RestAssured.given().log().all()
                .get(Constants.baseURL + Constants.userEndPoint + id);

    }

    public static Response getSingleResource(String id) {
        return RestAssured.given().log().all()
                .get(Constants.baseURL + Constants.resourceEndPoint + id);
    }

    public static Response registerUser(String email, String password) {
        return RestAssured.given().log().all().contentType("application/json")
                .body("{\"email\": \"" + email + "\",\n" + "    \"password\": \"" + password + "\"}")
                .post(Constants.baseURL + Constants.registerEndPoint);
    }

    public static Response deleteUser(int id) {
        return RestAssured.given().log().all()
                .delete(Constants.baseURL + Constants.userEndPoint + id);
    }

    public static Response createUser(String name, String job) {
        return RestAssured.given().log().all().contentType("application/json")
                .body("{\"name\": \"" + name + "\",\n" + "    \"job\": \"" + job + "\"}")
                .post(Constants.baseURL + Constants.userEndPoint);
    }
}



