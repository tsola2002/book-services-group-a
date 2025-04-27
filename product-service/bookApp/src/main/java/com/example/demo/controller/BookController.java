package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBooks(@RequestBody Book book){
        return bookService.addBooks(book);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
        return bookService.updateBook(id, bookDetails);
    }
    @DeleteMapping ("/{id}")
    public void deleteBooks(@PathVariable Long id){
       bookService.deleteBooks(id);
    }

}
