package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Table(name = "BOOK_LIBRARY")
public class Book {

    @Id

    @Column(name = "COL_BOOK_ID",unique = true)
    private Long bookId;

    @Column(name ="COL_BOOK_TITLE" )
    private String bookTitle;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name ="COL_YEAR" )
    private LocalDate bookYear;

    @Column(name ="COL_PRICE" )
    private String bookPrice;




    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getbookTitle() {
        return bookTitle;
    }

    public void setbookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getbookYear() {
        return bookYear;
    }

    public void setbookYear(LocalDate bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}
