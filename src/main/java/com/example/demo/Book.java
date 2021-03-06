package com.example.demo;

import lombok.Value;

@Value
public class Book {
    String author;
    String title;
    String isbn;
    int pages;
    BookType type;
}
