package com.dinesh.awsapigateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private List<Book> books = new ArrayList<Book>();

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        books.add(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("delete-book/{id}")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable int id){
        Predicate<Book> removeBook = book -> (book.getId() != id);
        books = books.stream().filter(removeBook).collect(Collectors.toList());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
