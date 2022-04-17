package com.application.bookstore.repository;

import com.application.bookstore.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreOrderRepository extends JpaRepository<OrderDetails,Long> {
}
