package com.application.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*@NoArgsConstructor
@Data
@AllArgsConstructor*/
@Entity
@Table(name = "order_details")
public class OrderDetails {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;
    private Date date;
    private Long price;
    private Long quantity;
    private String address;
    private String userId;


    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId_fk",referencedColumnName = "orderId")
    private List<Book> books;

    

	public OrderDetails() {
		super();
	}


	public OrderDetails(Long orderId, Date date, Long price, Long quantity, String address, String userId,
			List<Book> books) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.address = address;
		this.userId = userId;
		this.books = books;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    

}
