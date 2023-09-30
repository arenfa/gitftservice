package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.WrappingPaper;

@Repository
public interface WrappingPaperRepository extends JpaRepository<WrappingPaper, Long> {
  

}
