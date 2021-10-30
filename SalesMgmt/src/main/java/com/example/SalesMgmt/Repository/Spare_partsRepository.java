package com.example.SalesMgmt.Repository;

import com.example.SalesMgmt.Entity.Spare_parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Spare_partsRepository extends JpaRepository<Spare_parts, Integer> {
}
