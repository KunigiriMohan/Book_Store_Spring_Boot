package com.application.bookstore.serviceimplementation;

import com.application.bookstore.model.*;
import com.application.bookstore.repository.BookStoreBuyNowAddressRepository;
//import com.application.bookstore.repository.BookStoreBuyNowCartBooksRepository;
import com.application.bookstore.repository.BookStoreBuyNowRepository;
import com.application.bookstore.repository.BookStoreOrderRepository;
import com.application.bookstore.service.BookStoreBuyNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * */
@Service
public class BookStoreBuNowServiceImplementation implements BookStoreBuyNowService {

    /**
     * Autowiring Repository Interface to inject Address Object  to Save in DB
     */
    @Autowired
    BookStoreBuyNowAddressRepository bookStoreBuyNowAddressRepository;

    /**
     * Autowiring Repository Interface to inject Book Object  to Save in DB
     */
    @Autowired
    BookStoreBuyNowRepository bookStoreBuyNowRepository;

    @Autowired
    BookStoreOrderRepository bookStoreOrderRepository;

    /**
     * Method to buy Book from Homepage using Id
     * @param orderDATA
     * @return
     */
    @Override
    public Book buyNow(OrderDATA orderDATA) {
        Address address = new Address(orderDATA.getAddressDTO());
        bookStoreBuyNowAddressRepository.save(address);
        //Book book = new Book(bookDTO);
        bookStoreBuyNowRepository.save(orderDATA.getBook());
        return bookStoreBuyNowRepository.save(orderDATA.getBook());
    }

    /**
     * Method to buy Books in Cart
     * @param orderDATACart
     * @return
     */
    @Override
    public List<Book> buyNowBooksinCart(OrderDATACart orderDATACart) {
        Address address = new Address(orderDATACart.getAddressDTO());
        bookStoreBuyNowAddressRepository.save(address);
        bookStoreBuyNowRepository.saveAll(Arrays.asList(orderDATACart.getBook()));
        return bookStoreBuyNowRepository.saveAll(Arrays.asList(orderDATACart.getBook()));
    }
    @Override
    public OrderDetails saveOrder(OrderDetails order) {
       /* order.getBooks().stream().map(book -> {book.setOrderDetails(order);return order;});
        bookStoreBuyNowRepository.saveAll(order.getBooks());*/
        return bookStoreOrderRepository.save(order);
    }

    @Override
    public OrderDetails getOrderById(Long orderId) {
        return bookStoreOrderRepository.getById(orderId);
    }
}
