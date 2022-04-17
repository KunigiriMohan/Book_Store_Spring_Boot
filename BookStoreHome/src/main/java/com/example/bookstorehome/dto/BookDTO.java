package com.example.bookstorehome.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 * @AllArgsContructor: To Create Constructor
 * @NoArgsConstructor : To Create No Constructor
 */
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class BookDTO {
    private String bookName;
    private Long bookPrice;
    private String bookAuthor;
    private String publishedYear;
    private String bookPath;
    private Long quantity;
	private Long userid;
	
	
	
	public BookDTO() {
		super();
	}



	public BookDTO(String bookName, Long bookPrice, String bookAuthor, String publishedYear, String bookPath,
			Long quantity, Long userid) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.publishedYear = publishedYear;
		this.bookPath = bookPath;
		this.quantity = quantity;
		this.userid = userid;
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


	
    
    
}
