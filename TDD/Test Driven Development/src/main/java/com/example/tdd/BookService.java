package com.example.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author) {
        if(!BookInputValidations.isValidAuthor(author)) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
    
    public List<Book> getBooksByTitle(String title) {
        if(!BookInputValidations.isValidTitle(title)) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthorAndTitle(String author, String title) {
        if(!BookInputValidations.isValidAuthorAndTitle(author, title)) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getAuthor().equals(author) && book.getTitle().equals(title))
                .collect(Collectors.toList());
    }
}
