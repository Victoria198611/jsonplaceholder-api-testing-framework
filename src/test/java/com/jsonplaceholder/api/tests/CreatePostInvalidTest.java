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
public class CreatePostInvalidTest {

    @Test
    @Story("Negative POST request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that creating a post with an empty body returns 201 and default/null fields")
    public void testCreatePostWithEmptyBody(){
        // Custom Allure labels
        label("statusCode", "201");
        label("endpoint", "/posts");
        label("method", "POST");
        label("type", "negative");

        //BUILD Request body with empty
        Post newPost=new Post();

        //SEND post request
        Response response= PostService.createPost(newPost);

        //Validate status code
        Assert.assertEquals(response.getStatusCode(),201);

        //Deserialize response
        Post createdPost=response.as(Post.class);

        //Validate fields
        Assert.assertTrue(createdPost.getId()>0, "ID should be generated for POST request");
        Assert.assertEquals(createdPost.getUserId(),0,"UserId must be 0 when request body is empty");
        Assert.assertNull(createdPost.getTitle(), "Title must remain null for an empty POST body");
        Assert.assertNull(createdPost.getBody(),"Body must remain null for an empty POST body");
    }
}
