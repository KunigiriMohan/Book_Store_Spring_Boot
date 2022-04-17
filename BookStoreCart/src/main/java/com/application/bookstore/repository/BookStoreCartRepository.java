package com.application.bookstore.repository;

import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Repository : Creating Repository
 */
@Repository
@EnableJpaRepositories
public interface BookStoreCartRepository extends JpaRepository<Book,Long> {

    @Query("select sum(book.bookPrice*book.quantity)from Book book where book.userid=:userid")
    public Long cartValue(@Param("userid") Long id);

    @Query("select book from Book book where book.userid=:userid")
    List<Book> getBooksByUserID(@Param("userid") Long iD);
   /* @Query("select new com.application.bookstore.model.Book(book.bookId,book.id,book.bookName,book.bookPrice,book.bookAuthor,book.publishedYear,book.bookPath,book.quantity,book.userid,book.bookPrice*book.quantity as book.totalBookPrice) from Book book where book.userid=:userid")
    List<Book> getBooksByUserID(@Param("userid") Long iD);*/

    @Transactional
    @Modifying
    @Query("delete from Book book where book.userid=:userid")
    void deleteBooksByUserIDinCart(@Param("userid") Long iD);

    @Query("select count(b.id) from Book b")
    Long getNoOfBooksinCart();

    @Query("select b from Book b where b.id=:name")
    Book getBookByName(@Param("name") Long bookName);

    @Query("select count(book.id) from Book book where book.userid=:userid")
    Long getBooksCountByUserID(@Param("userid") Long iD);

    @Transactional
    @Modifying
    @Query("update Book b set b.quantity=:quant where b.bookId=:id")
    Object updateBookQuantity(@Param("quant") Long quantity,@Param("id") Long bookid);
}