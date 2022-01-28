package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

    @QueryMapping
    public Book book(@Argument final String isbn) {
        return switch (isbn) {
            case "1" -> new Book("Clive Cussler", "Sahara", isbn);
            case "2" -> new Book("Ian Fleming", "Dr No", isbn);
            case "3" -> new Book("Herman Melville", "Moby Dick", isbn);
            case "4" -> new Book("Jules Verne", "Twenty Thousand Leagues Under the Seas", isbn);
            case "5" -> new Book("Clive Cussler", "Raise the Titanic!", isbn);
            default -> new Book("Nemo", "Nothing", isbn);
        };
    }
}
