package com.training.api.http;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.config;
import static io.restassured.config.LogConfig.logConfig;

class ApiSpecProvider {
    private static String API_KEY = System.getProperty("test.apiKey");

    static RequestSpecification booksApi() {
        RequestSpecification booksApiSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.nytimes.com/svc/books/v3/lists")
                .addHeader("api-key", API_KEY)
                .setConfig(config().logConfig(
                        logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build();

        return RestAssured.given().spec(booksApiSpec);
    }
}
