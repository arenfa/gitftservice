package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
  

}
