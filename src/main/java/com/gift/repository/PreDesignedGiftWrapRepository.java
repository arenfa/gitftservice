package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.PreDesignedGiftWrap;

@Repository
public interface PreDesignedGiftWrapRepository extends JpaRepository<PreDesignedGiftWrap, Long> {
  

}
