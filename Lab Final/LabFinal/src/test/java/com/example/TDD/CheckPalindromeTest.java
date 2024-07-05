package com.example.TDD;

import org.example.CheckPalindrome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class CheckPalindromeTest {

    private CheckPalindrome palindrome;

    @BeforeEach
    public void setUp() {
        palindrome = new CheckPalindrome();
    }

    @Test
    public void testCheckPalindrome_isPalindrome() {
        System.out.println("Verify the testCheckPalindrome_isPalindrome Test");
        String str = "mam";
        boolean result = palindrome.isPalindrome(str);
        Assertions.assertEquals(true, result);

    }

    @Test
    public void testCheckPalindrome_isNotPalindrome() {
        System.out.println("Verify the testCheckPalindrome_isNotPalindrome Test");
        String str = "Hello";
        boolean result = palindrome.isPalindrome(str);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testCheckPalindrome_nullString() {
        System.out.println("Verify the testCheckPalindrome_nullString Test");
        String str = null;
        boolean result = palindrome.isPalindrome(str);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testCheckPalindrome_EmptyString() {
        System.out.println("Verify the testCheckPalindrome_EmptyString Test");
        String str = "";
        boolean result = palindrome.isPalindrome(str);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testCheckPalindrome_SingleCharacterString() {
        System.out.println("Verify the testCheckPalindrome_SingleCharacterString Test");
        String str = "a";
        boolean result = palindrome.isPalindrome(str);
        Assertions.assertEquals(true, result);
    }

}
