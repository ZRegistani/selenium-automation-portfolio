package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiSmokeTest {

    @Test
    public void api_smoke_get_post_1() {

        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Response response =
                given()
                        .accept(ContentType.JSON)
                .when()
                        .get(url)
                .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();

        // Light “assurance” check: response time < 2 seconds
        long ms = response.time();
        Assert.assertTrue(ms < 2000, "Expected response time < 2000ms, but was " + ms + "ms");

        int id = response.jsonPath().getInt("id");
        int userId = response.jsonPath().getInt("userId");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        Assert.assertEquals(id, 1, "Expected id=1");
        Assert.assertTrue(userId > 0, "Expected userId > 0");

        Assert.assertNotNull(title, "title should not be null");
        Assert.assertTrue(title.trim().length() > 0, "title should not be empty");

        Assert.assertNotNull(body, "body should not be null");
        Assert.assertTrue(body.trim().length() > 0, "body should not be empty");
    }
}

