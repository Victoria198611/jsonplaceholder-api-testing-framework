package com.jsonplaceholder.api.tests;

import com.jsonplaceholder.api.services.PostService;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.label;

@Epic("JSONPlaceholder API")
@Feature("Posts API")
public class DeletePostInvalidTest {

    @Test
    @Story("Negative DELETE request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that deleting a post with an invalid ID returns 200 and an empty or {} response body")
public void testDeletePostWithInvalidId(){
        // Custom Allure labels
        label("statusCode", "200");
        label("endpoint", "/posts/{id}");
        label("method", "DELETE");
        label("type", "negative");
        int id=999999;

        //SEND Delete request
        Response response= PostService.deletePost(id);

        //Validate status code
        Assert.assertEquals(response.getStatusCode(),200, "Status code should be 200 for invalid DELETE");

        // Validate body: JSONPlaceholder returns {} or empty string
    String body=response.getBody().asString();
    Assert.assertTrue(body.isEmpty()||body.equals("{}"), "Response body should be empty or {} for DELETE request");
    }
}
