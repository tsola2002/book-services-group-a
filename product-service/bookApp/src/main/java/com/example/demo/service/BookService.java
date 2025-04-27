package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    inject book (entity) repository using field injection

    @Autowired
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book addBooks(Book book){
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book bookDetails){
        return bookRepo.findById(id).map(book -> {
            book.setbookTitle(bookDetails.getbookTitle());
            book.setbookYear(bookDetails.getbookYear());
            book.setBookPrice(bookDetails.getBookPrice());
            return bookRepo.save(book);
        }).orElseThrow(()-> new RuntimeException("who be you"+id));
    }

    public void deleteBooks(Long id){
        bookRepo.deleteById(id);
    }


}
