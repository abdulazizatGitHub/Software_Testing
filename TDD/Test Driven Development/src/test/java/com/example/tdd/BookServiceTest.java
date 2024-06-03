package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        //IBookRepository bookRepository = new BookRepository();
        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_returnNull() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthor_MoreThanOneBookFound() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Kent Beck"),
                new Book("3", "Effective Java", "Kent Beck")
        );
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(3, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_emptyAuthorField() {
        List<Book> books = bookService.getBooksByAuthor("");
        Assertions.assertTrue(books.isEmpty());
    }

    // Get Book By Title Test Cases

    @Test
    public void testBookByTitle() {
        List<Book> books = bookService.getBooksByTitle("Test Driven Development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Kent Beck", books.get(0).getAuthor());
    }

    @Test
    public void testBookByTitle_NoBookFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByTitle_returnNull() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByTitle_MoreThanOneBookFound() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Test Driven Development", "Robert C. Martin"),
                new Book("3", "Test Driven Development", "Joshua Bloch")
        );
        List<Book> books = bookService.getBooksByTitle("Test Driven Development");
        Assertions.assertEquals(3, books.size());
        Assertions.assertEquals("Robert C. Martin", books.get(1).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_emptyTitleField() {
        List<Book> books = bookService.getBooksByTitle("");
        Assertions.assertTrue(books.isEmpty());
    }

    // Get Book By Author and Title Test Cases

    @Test
    public void testBookByAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Kent Beck", books.get(0).getAuthor());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testBookByAuthorAndTitle_NoBookFound() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testBookByAuthorAndTitle_returnNull() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testBookByAuthorAndTitle_emptyAuthorField() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("", "Test Driven Development");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testBookByAuthorAndTitle_emptyTitleField() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testBookByAuthorAndTitle_emptyTitleAndAuthorField() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("", "");
        Assertions.assertTrue(books.isEmpty());
    }
}
