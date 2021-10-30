package com.example.SalesMgmt.Service;

import com.example.SalesMgmt.DTO.Spare_parts_typeDTO;
import com.example.SalesMgmt.Entity.Spare_parts_type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Spare_parts_type_Service {
    Spare_parts_typeDTO addSpare_parts_type(Spare_parts_typeDTO spare_parts_type);

    Page<Spare_parts_type> listAllDetails(int pageNo , int pageSize, String sortBy);

    Spare_parts_type getProductDetailsByID(int id);

    Spare_parts_type updateProductDetails(Object spare_parts_type);

    String deleteDetailsById(int id);

    List<Spare_parts_type> saveAllDetails(List<Spare_parts_type> product);
}
