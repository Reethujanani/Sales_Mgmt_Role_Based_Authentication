package com.example.SalesMgmt.Service.ServiceImpl;

import com.example.SalesMgmt.DTO.Spare_parts_typeDTO;
import com.example.SalesMgmt.Entity.Spare_parts_type;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Repository.Spare_parts_typeRepository;
import com.example.SalesMgmt.Service.Spare_parts_type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class Spare_parts_type_ServiceImpl implements Spare_parts_type_Service {

    @Autowired
    private Spare_parts_typeRepository spare_parts_typeRepository;

    @Override
    public Spare_parts_typeDTO addSpare_parts_type(Spare_parts_typeDTO spare_parts_type) {
        try {
            Spare_parts_type spare_parts_type1 = new Spare_parts_type();
            spare_parts_type1.setParts_type_name(spare_parts_type.getParts_type_name());
            spare_parts_type1.setParts_type_description(spare_parts_type.getParts_type_description());
            spare_parts_type1.setIs_active(spare_parts_type.getIs_active());
            spare_parts_type1.setIs_deleted(spare_parts_type.getIs_deleted());
            spare_parts_typeRepository.save(spare_parts_type1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return spare_parts_type;
    }

    @Override
    public Page<Spare_parts_type> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Spare_parts_type> spare_parts_types = spare_parts_typeRepository.findAll(pageable);
         return spare_parts_types;
    }


    @Override
    public Spare_parts_type getProductDetailsByID(int id) {
        return null;
    }

    @Override
    public Spare_parts_type updateProductDetails(Object spare_parts_type) {
        return null;
    }

    @Override
    public String deleteDetailsById(int id) {
        spare_parts_typeRepository.deleteById(id);
        return "Success";
    }


    @Override
    public List<Spare_parts_type> saveAllDetails(List<Spare_parts_type> product) {
        return null;
    }
}
