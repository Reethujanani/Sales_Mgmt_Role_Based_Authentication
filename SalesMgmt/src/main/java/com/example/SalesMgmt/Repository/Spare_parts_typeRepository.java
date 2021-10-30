package com.example.SalesMgmt.Repository;

import com.example.SalesMgmt.Entity.Spare_parts_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Spare_parts_typeRepository extends JpaRepository<Spare_parts_type, Integer> {
}
