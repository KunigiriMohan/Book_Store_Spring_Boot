package com.application.bookstore;

import com.application.bookstore.model.Book;
import com.application.bookstore.repository.BookStoreCartEntityRepository;
import com.application.bookstore.repository.BookStoreCartRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookStoreCartEntity implements BookStoreCartEntityRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Modifying
    @Override
    public Object updateBook(Long quantity, Long bookId) {
        String query ="update Book b set b.quantity=:quant where b.bookId=:id";
        Query query1 = entityManager.createQuery(query).setParameter("id",bookId).setParameter("quant",quantity);
        return  query1.getSingleResult();
    }
}
