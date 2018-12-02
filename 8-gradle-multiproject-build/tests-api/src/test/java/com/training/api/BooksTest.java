package com.training.api;

import com.training.api.domain.Book;
import com.training.api.http.BooksOperations;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Books")
@Tag("All")
class BooksTest {

    @Test
    void searchByAuthor() {
        String author = "Dan Brown";
        String bookName = "Angels and Demons";
        List<Book> books = new BooksOperations().getBooksByAuthor(author);

        assertThat(books)
                .hasSize(4)
                .anyMatch(b -> b.getTitle().equalsIgnoreCase(bookName))
                .extracting(Book::getAuthor).allMatch(author::equals);
    }

    @Test
    void searchByIsbn() {
        String isbn10 = "0385537859";
        String isbn13 = "9780385537858";
        List<Book> booksByIsbn10 = new BooksOperations().getBooksByIsbn(isbn10);
        List<Book> booksByIsbn13 = new BooksOperations().getBooksByIsbn(isbn13);

        assertThat(booksByIsbn10).hasSize(1);
        assertThat(booksByIsbn10.get(0).getAuthor()).isEqualTo("Dan Brown");
        assertThat(booksByIsbn10.get(0).getTitle()).containsIgnoringCase("Inferno");

        assertThat(booksByIsbn13).hasSize(1);
        assertThat(booksByIsbn13.get(0).getAuthor()).isEqualTo("Dan Brown");
        assertThat(booksByIsbn13.get(0).getTitle()).containsIgnoringCase("Inferno");
    }
}
