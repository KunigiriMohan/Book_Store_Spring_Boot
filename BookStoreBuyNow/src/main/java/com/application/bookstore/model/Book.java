package com.application.bookstore.model;

import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
@Entity
@Table(name = "book_list")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private Long bookPrice;
    private String bookAuthor;
    private String publishedYear;
    private String bookPath;
    private Long quantity;
    private Long userid;
    private Long id;
    private Long totalBookPrice;
}
