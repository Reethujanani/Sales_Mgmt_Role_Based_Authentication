package com.example.SalesMgmt.Service.ServiceImpl;

import com.example.SalesMgmt.DTO.Spare_partsDTO;
import com.example.SalesMgmt.Entity.Spare_parts;
import com.example.SalesMgmt.Entity.Spare_parts_type;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Repository.Spare_partsRepository;
import com.example.SalesMgmt.Repository.Spare_parts_typeRepository;
import com.example.SalesMgmt.Service.Spare_parts_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Spare_parts_ServiceImpl implements Spare_parts_Service {

    @Autowired
    private Spare_partsRepository spare_partsrepository;

    @Autowired
    private Spare_parts_typeRepository setSpare_parts;

    @Override
    public Spare_partsDTO addSpare_parts(Spare_partsDTO spare_parts) {
        Spare_parts spare_parts1 = new Spare_parts();

        Optional<Spare_parts_type> spare_parts_type = setSpare_parts.findById(spare_parts.getSpare_parts_type_id_fk());
        if(spare_parts_type.isPresent()){
            spare_parts1.setSpare_parts_type(spare_parts_type.get());
        }
        spare_parts1.setParts_name(spare_parts.getParts_name());
        spare_parts1.setIs_active(spare_parts.getIs_active());
        spare_parts1.setIs_deleted(spare_parts.getIs_deleted());
        try {
            spare_partsrepository.save(spare_parts1);
        }catch (Exception e){
            e.getMessage();
        }
        return spare_parts;
    }

    @Override
    public List<Spare_parts> listAllDetails() {
        return null;
    }

    public Spare_parts getProductDetailsByID(int id) {
        Optional<Spare_parts> user = spare_partsrepository.findById(id);
        return user.get();
    }

    @Override
    public Page<Spare_parts> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Spare_parts> spare_parts = spare_partsrepository.findAll(pageable);
        return spare_parts;
    }


    @Override
    public Spare_partsDTO updateProductDetails(Spare_partsDTO spare_parts) {
        return null;
    }

    @Override
    public String deleteDetailsById(int id) {
         spare_partsrepository.deleteById(id);
         return "Successfully deleted";
    }
}
