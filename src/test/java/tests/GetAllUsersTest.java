package tests;

import Requests.Constants;
import Requests.UserRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUsersTest {
        Response response = UserRequests.getAllUsers();

            @Test
            public void testStatusCodeIs200() {
                Assert.assertEquals(response.getStatusCode(), 200);
            }

            @Test
            public void testResponseIsAnObject() {
                Assert.assertTrue(response.jsonPath().get() instanceof java.util.Map);
            }

            @Test
            public void testResponseTimeIsLessThan500ms() {
                Assert.assertTrue(response.time() < 500.00);
            }

            @Test
            public void testPagePropertyExists() {
                Assert.assertNotNull(response.jsonPath().get("page"));
            }

            @Test
            public void testPageIsPositive() {
                int page = response.jsonPath().getInt("page");
                Assert.assertTrue(page > 0);
            }

            @Test
            public void testTotalPropertyExists() {
                Assert.assertNotNull(response.jsonPath().get("total"));
            }

            @Test
            public void testTotalIsPositive() {
                int total = response.jsonPath().getInt("total");
                Assert.assertTrue(total > 0);
            }

            @Test
            public void testPerPagePropertyExists() {
                Assert.assertNotNull(response.jsonPath().get("per_page"));
            }

            @Test
            public void testPerPageIsPositive() {
                int perPage = response.jsonPath().getInt("per_page");
                Assert.assertTrue(perPage > 0);
            }

            @Test
            public void testTotalPagesPropertyExists() {
                Assert.assertNotNull(response.jsonPath().get("total_pages"));
            }

            @Test
            public void testTotalPagesIsPositive() {
                int totalPages = response.jsonPath().getInt("total_pages");
                Assert.assertTrue(totalPages > 0);
            }

            @Test
            public void testResponseHasDataArray() {
                Assert.assertTrue(response.jsonPath().get("data") instanceof java.util.List);
            }
        }