package com.training.api.http;

import com.training.api.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.training.api.http.ApiSpecProvider.booksApi;

public class BooksOperations {

    public List<Book> getBooksByAuthor(String author) {
        Map<String, Object> params = new HashMap<>();
        params.put("author", author);
        return getBooks(params);
    }

    public List<Book> getBooksByIsbn(String isbn) {
        Map<String, Object> params = new HashMap<>();
        params.put("isbn", isbn);
        return getBooks(params);
    }

    private List<Book> getBooks(Map<String, Object> searchTerms) {
        return booksApi()
                .queryParams(searchTerms)
                .when().get("/best-sellers/history.json")
                .then().statusCode(200)
                .extract().jsonPath().getList("results", Book.class);
    }
}