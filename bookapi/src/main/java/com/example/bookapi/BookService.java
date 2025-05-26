package com.example.bookapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Read (Get All)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Read (Get by ID)
    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    // Update
    public Book updateBook(Long bookId, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setBookName(updatedBook.getBookName());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }

    // Delete
    public void deleteBook(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }
}