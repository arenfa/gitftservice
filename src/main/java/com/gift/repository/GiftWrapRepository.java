package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.GiftWrap;

@Repository
public interface GiftWrapRepository extends JpaRepository<GiftWrap, Long> {
  

}
