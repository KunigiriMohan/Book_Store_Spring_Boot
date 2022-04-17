package com.example.bookstorehome.controller;

import com.example.bookstorehome.dto.BookDTO;
import com.example.bookstorehome.model.Book;
import com.example.bookstorehome.service.BookStoreHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController : Defining Class as a RestController
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @Autowired : Dependency Injection
 */
@CrossOrigin
@RestController
public class BookStoreHomeController {

    /**
     * Autowiring Service Interface for Dependency Injection
     */
    @Autowired
    BookStoreHomeService bookStoreHomeService;

    /**
     * API for adding book to DB
     * @param bookDTO
     * @return : Book Object
     */
    @PostMapping("/addbook")
    public Book addBook(@RequestBody BookDTO bookDTO){
        Book book = new Book(bookDTO);
        return bookStoreHomeService.addBook(book);
    }

    /**
     * API for get Book Object by ID
     * @param id
     * @return : Book Object
     */
    @GetMapping("/getbyid/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookStoreHomeService.getBookById(id);
    }

    /**
     * API for Getting all Books in Home Page
     * @return : Book Object
     */
    @GetMapping("/getallbooks")
    public List<Book> getAllBooks(){
        return bookStoreHomeService.getAllBooks();
    }

    @GetMapping("/getallbooks/{bookName}")
    public List<Book> getAllBooksByname(@PathVariable("bookName")String bookName){
        return bookStoreHomeService.getBooksByName(bookName);
    }

    @GetMapping("/getbooks/{number}")
    public List<Book> getAllBooksByPrice(@PathVariable("number")Long number){
        return bookStoreHomeService.getBooksByPrice(number);
    }
}
