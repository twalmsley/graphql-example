package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

    private final Book[] books = {
            new Book("Clive Cussler", "Sahara", "1", 100, BookType.FICTION),
            new Book("Ian Fleming", "Dr No", "2", 200, BookType.FICTION),
            new Book("Herman Melville", "Moby Dick", "3", 300, BookType.FICTION),
            new Book("Jules Verne", "Twenty Thousand Leagues Under the Seas", "4", 400, BookType.FICTION),
            new Book("Clive Cussler", "Raise the Titanic!", "5", 500, BookType.FICTION)
    };

    @QueryMapping
    public Book book(@Argument final String isbn) {
        return switch (isbn) {
            case "1" -> books[0];
            case "2" -> books[1];
            case "3" -> books[2];
            case "4" -> books[3];
            case "5" -> books[4];
            default -> new Book("Nemo", "Nothing", isbn, 0, BookType.FICTION);
        };
    }


    @QueryMapping
    public Collection<Book> books() {
        return List.of(books);
    }
}
