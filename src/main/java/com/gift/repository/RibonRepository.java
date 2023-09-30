package com.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gift.model.Ribon;

@Repository
public interface RibonRepository extends JpaRepository<Ribon, Long> {
  

}
