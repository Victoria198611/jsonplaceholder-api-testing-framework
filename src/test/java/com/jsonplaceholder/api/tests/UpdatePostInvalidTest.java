package com.jsonplaceholder.api.tests;

import com.jsonplaceholder.api.models.Post;
import com.jsonplaceholder.api.services.PostService;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.label;

@Epic("JSONPlaceholder API")
@Feature("Posts API")
public class UpdatePostInvalidTest {

    @Test
    @Story("Negative PUT request")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that updating a post with an invalid ID and empty body returns 500 and a non-null response body")
    public void testUpdatePostWithInvalidId() {
        // Custom Allure labels
        label("statusCode", "500");
        label("endpoint", "/posts/{id}");
        label("method", "PUT");
        label("type", "negative");
        int invaliId = 999999;


        //Build incomplete/empty request body
        Post updatedPost = new Post();

//Send PUT request
        Response response = PostService.updatePost(invaliId, updatedPost);

        //JSONPlaceholder returns 500 for invalid PUT with empty or incomplete body
        Assert.assertEquals(response.getStatusCode(), 500, "Status code should be 500 for invalid PUT request with empty body");

        //Body is usually empty or {}
        String body = response.getBody().asString();
        Assert.assertNotNull(body, "Response body should not be null for invalid PUT request");
    }
}