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
public class CreatePostTest {

    @Test
    @Story("Positive POST request")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that creating a post with valid fields returns 201 and the response contains the same data")
    public void testCreatePost() {

        // Custom Allure labels
        label("statusCode", "201");
        label("endpoint", "/posts");
        label("method", "POST");
        label("type", "positive");

        //BUILD request body
        Post newPost = new Post();
        newPost.setUserId(10);
        newPost.setTitle("Victoria Test Title");
        newPost.setBody("This is a test body created by automation.");

        //Send Post request
        Response response = PostService.createPost(newPost);

        //Validate status Code
        Assert.assertEquals(response.getStatusCode(), 201);

        //Deserialize response
        Post createdPost = response.as(Post.class);

        //Validate fields
        Assert.assertEquals(createdPost.getUserId(), newPost.getUserId());
        Assert.assertEquals(createdPost.getTitle(), newPost.getTitle());
        Assert.assertEquals(createdPost.getBody(), newPost.getBody());

        // JSONPlaceholder returns a fake id, but we can still check it's > 0
        Assert.assertTrue(createdPost.getId()>0);
    }
    }