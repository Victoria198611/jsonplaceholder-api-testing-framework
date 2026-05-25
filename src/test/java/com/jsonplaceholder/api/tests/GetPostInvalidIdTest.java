package com.jsonplaceholder.api.tests;

import com.jsonplaceholder.api.services.PostService;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.label;

@Epic("JSONPlaceholder API")
@Feature("Posts API")
public class GetPostInvalidIdTest {

    @Test
    @Story("Negative GET request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that retrieving a post with an invalid ID returns 404 and an empty or {} response body")
    public void testPostInvalidid() {
        label("statusCode", "404");
        label("endpoint", "/posts/{id}");
        label("method", "GET");
        label("type", "negative");
        int invalidId=999999;

        //SEND Get request with invalid ID
        Response response = PostService.getPostId(invalidId);

        //Validate status code (JSONPlaceholder returns 404 even for invalid IDs)
        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 for invalid post ID");

        //Validate body: JSONPlaceholder returns {} for invalid GET
    String body=response.getBody().asString();
    Assert.assertTrue(body.equals("{}")||body.isEmpty(),"Body should be {} or empty for invalid GET request");
    }
}