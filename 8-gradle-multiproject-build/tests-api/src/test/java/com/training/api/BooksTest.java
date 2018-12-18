package com.training.api;

import com.training.api.domain.Book;
import com.training.api.http.BooksOperations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Books")
@Tag("All")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BooksTest {

    private BooksOperations booksOperations = new BooksOperations();

    @Test
    @DisplayName("search book by author")
    void searchByAuthor() {
        String author = "Dan Brown";
        String bookName = "Angels and Demons";
        List<Book> books = booksOperations.getBooksByAuthor(author);

        assertThat(books)
                .hasSize(4)
                .anyMatch(b -> b.getTitle().equalsIgnoreCase(bookName))
                .extracting(Book::getAuthor).allMatch(author::equals);
    }

    @Test
    @DisplayName("search book by ISBN")
    void searchByIsbn() {
        String isbn10 = "0385537859";
        String isbn13 = "9780385537858";
        List<Book> booksByIsbn10 = booksOperations.getBooksByIsbn(isbn10);
        List<Book> booksByIsbn13 = booksOperations.getBooksByIsbn(isbn13);

        assertThat(booksByIsbn10).hasSize(1);
        assertThat(booksByIsbn10.get(0).getAuthor()).isEqualTo("Dan Brown");
        assertThat(booksByIsbn10.get(0).getTitle()).containsIgnoringCase("Inferno");
        assertThat(booksByIsbn10.get(0).getIsbns())
                .anySatisfy(isbn -> {
                            assertThat(isbn.getIsbn10()).isEqualTo(isbn10);
                            assertThat(isbn.getIsbn13()).isEqualTo(isbn13);
                        }
                );

        assertThat(booksByIsbn13).hasSize(1);
        assertThat(booksByIsbn13.get(0).getAuthor()).isEqualTo("Dan Brown");
        assertThat(booksByIsbn13.get(0).getTitle()).containsIgnoringCase("Inferno");
        assertThat(booksByIsbn13.get(0).getIsbns())
                .anySatisfy(isbn -> {
                            assertThat(isbn.getIsbn10()).isEqualTo(isbn10);
                            assertThat(isbn.getIsbn13()).isEqualTo(isbn13);
                        }
                );
    }
}
