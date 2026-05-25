package com.jsonplaceholder.api.services;

import com.jsonplaceholder.api.config.TestConfig;
import com.jsonplaceholder.api.models.Post;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostService {
    private static final String BASE_URL = TestConfig.getBaseUrl();

    //GET all posts
    public static Response getAllPosts() {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .get(BASE_URL + "/posts");
    }

    //GET post by ID
    public static Response getPostId(int id) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .get(BASE_URL + "/posts/" + id);
    }

    //POST create New Post
    public static Response createPost(Post post) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .post(BASE_URL + "/posts");
    }

    //PUT update POST
    public static Response updatePost(int id, Post post) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .put(BASE_URL + "/posts/" + id);
    }

    //DELETE POST
    public static Response deletePost(int id) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .delete(BASE_URL + "/posts/" + id);
    }
}
