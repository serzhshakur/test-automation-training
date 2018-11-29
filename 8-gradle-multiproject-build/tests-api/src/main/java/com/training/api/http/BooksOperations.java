package com.training.api.http;

import com.training.api.domain.Book;
import io.restassured.RestAssured;

import java.util.List;

public class BooksOperations {

    public List<Book> getBooksByAuthor(String author) {
        String apiKey = System.getProperty("apiKey");

        return RestAssured.given()
                .baseUri("http://api.nytimes.com/svc/books/v3/lists")
                .header("api-key", apiKey)
                .queryParam("author", author)
                .when().get("/best-sellers/history.json")
                .then().statusCode(200)
                .extract().jsonPath().getList("results", Book.class);
    }
}
