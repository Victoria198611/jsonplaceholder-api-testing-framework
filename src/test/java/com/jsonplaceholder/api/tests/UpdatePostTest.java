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
public class UpdatePostTest {
    @Test
    @Story("Positive PUT request")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that updating a post with valid fields returns 200 and the response contains updated data")
            public void testUpdatedPost() {
        label("statusCode", "200");
        label("endpoint", "/posts/{id}");
        label("method", "PUT");
        label("type", "positive");

        int id = 1;

        //Build update post body
        Post updatedPost = new Post();
        updatedPost.setUserId(99);
        updatedPost.setTitle("Updated Title by Victoria");
        updatedPost.setBody("Updated body content via automation");

        //Send PUT request
        Response response = PostService.updatePost(id, updatedPost);

        //Validate status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Deserialize response
        Post responsePost = response.as(Post.class);

        //Validate fields
        Assert.assertEquals(responsePost.getId(), id);
        Assert.assertEquals(responsePost.getUserId(), updatedPost.getUserId());
        Assert.assertEquals(responsePost.getTitle(), updatedPost.getTitle());
        Assert.assertEquals(responsePost.getBody(), updatedPost.getBody());
    }
}
