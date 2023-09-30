package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  

}
