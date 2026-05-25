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
public class GetPostByIdTest {

    @Test
    @Story("Positive GET request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that retrieving a post by ID returns 200 and the response contains valid post fields")
    public void testGetPostById(){
        // Custom Allure labels
        label("statusCode", "200");
        label("endpoint", "/posts/{id}");
        label("method", "GET");
        label("type", "positive");
        int id=1;
        Response response= PostService.getPostId(id);

        //Status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Deserialize JSON → Post object
        Post post=response.as(Post.class);

        //Validate fields
        Assert.assertEquals(post.getId(), id);
        Assert.assertTrue(post.getUserId()>0);
        Assert.assertNotNull(post.getTitle());
        Assert.assertNotNull(post.getBody());
    }
}
