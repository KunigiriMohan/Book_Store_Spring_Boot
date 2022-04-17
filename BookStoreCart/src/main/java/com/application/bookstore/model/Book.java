package com.application.bookstore.model;

import com.application.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 * @AllArgsContructor: To Create Constructor
 * @NoArgsConstructor : To Create No Constructor
 * @Table : Creating Table and Declaring Name
 * @Entity : To Create Entity of Class
 */
//@NoArgsConstructor
@Entity
@Table(name = "book_list")
//@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private Long id;
    private String bookName;
    private Long bookPrice;
    private String bookAuthor;
    private String publishedYear;
    private String bookPath;
    private Long quantity;
    private Long userid;
    private Long totalBookPrice;

    public Book() {
    }

    
    public Book(Long bookId, Long id, String bookName, Long bookPrice, String bookAuthor, String publishedYear,
			String bookPath, Long quantity, Long userid, Long totalBookPrice) {
		super();
		this.bookId = bookId;
		this.id = id;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.publishedYear = publishedYear;
		this.bookPath = bookPath;
		this.quantity = quantity;
		this.userid = userid;
		this.totalBookPrice = totalBookPrice;
	}


	/*@ManyToOne
    @JoinColumn(name = "fk_userID",referencedColumnName = "iD")
    private User user;*/

    public Book(BookDTO bookDTO){
        this.updateBookDetails(bookDTO);
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Long bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getTotalBookPrice() {
        return totalBookPrice;
    }

    public void setTotalBookPrice(Long totalBookPrice) {
        this.totalBookPrice = totalBookPrice;
    }

    public void updateBookDetails(BookDTO bookDTO){
        this.id = bookDTO.getId();
        this.bookName = bookDTO.getBookName();
        this.bookPrice = bookDTO.getBookPrice();
        this.bookAuthor = bookDTO.getBookAuthor();
        this.publishedYear = bookDTO.getPublishedYear();
        this.bookPath = bookDTO.getBookPath();
        this.quantity = bookDTO.getQuantity();
        this.userid = bookDTO.getUserId();
    }
}
