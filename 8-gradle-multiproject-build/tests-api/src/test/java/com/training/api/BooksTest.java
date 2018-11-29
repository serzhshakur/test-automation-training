package com.training.api;

import com.training.api.domain.Book;
import com.training.api.http.BooksOperations;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("All")
class BooksTest {
    @Test
    void test() {
        String author = "Dan Brown";
        String bookName = "Angels and Demons";
        List<Book> books = new BooksOperations().getBooksByAuthor(author);

        assertThat(books).anyMatch(b -> b.getTitle().equalsIgnoreCase(bookName));
        assertThat(books).extracting(Book::getAuthor).allMatch(author::equals);
    }
}
