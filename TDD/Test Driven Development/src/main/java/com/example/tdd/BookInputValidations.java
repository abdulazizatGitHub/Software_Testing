package com.example.tdd;

public class BookInputValidations {

    public static boolean isValidAuthor(String author) {
        return author != null && !author.trim().isEmpty();
    }

    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty();
    }

    public static boolean isValidAuthorAndTitle(String author, String title) {
        return isValidAuthor(author) && isValidTitle(title);
    }
}
