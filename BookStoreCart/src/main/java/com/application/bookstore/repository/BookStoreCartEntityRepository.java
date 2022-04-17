package com.application.bookstore.repository;

import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreCartEntityRepository {
    @Modifying
    Object updateBook(Long quantity,Long bookId);
}
