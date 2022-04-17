package com.application.bookstore.controller;

import com.application.bookstore.model.Book;
import com.application.bookstore.model.OrderDATA;
import com.application.bookstore.model.OrderDATACart;
import com.application.bookstore.model.OrderDetails;
import com.application.bookstore.repository.BookStoreBuyNowRepository;
import com.application.bookstore.service.BookStoreBuyNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController : Defining Class as a RestController
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @Autowired : Dependency Injection
 */
@RestController
@CrossOrigin
public class BookStoreBuyNowController {

    /**
     * Autowiring Service Interface for Dependency Injection
     */
    @Autowired
    BookStoreBuyNowService bookStoreBuyNowService;

    @Autowired
    BookStoreBuyNowRepository bookStoreBuyNowRepository;

    /**
     * API for buying Book from Home page using id
     * @param orderDATA
     * @return : Book
     */
    @PostMapping("/buynow")
    public Book buyNow(@RequestBody OrderDATA orderDATA){
        return bookStoreBuyNowService.buyNow(orderDATA);
    }

    /**
     * API for buying Books present in Cart
     * @param orderDATACart
     * @return : List of Books present in Cart
     */
    @PostMapping("/buyallproductsincart")
    public List<Book> buyNowBooksinCart(@RequestBody OrderDATACart orderDATACart){
        return bookStoreBuyNowService.buyNowBooksinCart(orderDATACart);
    }

    /**
     * API to get total price of all books present in Cart
     * @return : Total Value of Books present in Cart
     */
    @GetMapping("/carttotal")
    public Long totalCartValue(){return bookStoreBuyNowRepository.cartValue();}

    @PostMapping("/order")
    public OrderDetails order(@RequestBody OrderDetails order){
        return bookStoreBuyNowService.saveOrder(order);
    }


    @GetMapping("/getorderbyid/{id}")
    public OrderDetails getOrderById(@PathVariable("id") Long id){
        return bookStoreBuyNowService.getOrderById(id);
    }
}
