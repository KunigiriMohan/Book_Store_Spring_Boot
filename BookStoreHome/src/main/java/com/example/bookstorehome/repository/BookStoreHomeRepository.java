package com.example.bookstorehome.repository;

import com.example.bookstorehome.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreHomeRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.bookName like :name%")
    List<Book> getAllBooksbyName(@Param("name") String bookName);

    @Query("select b from Book b order by b.bookPrice ASC")
    List<Book> getAllBooksbyPriceAsscending();

    @Query("select b from Book b order by b.bookPrice DESC ")
    List<Book> getAllBooksbyPriceDescending();
}
