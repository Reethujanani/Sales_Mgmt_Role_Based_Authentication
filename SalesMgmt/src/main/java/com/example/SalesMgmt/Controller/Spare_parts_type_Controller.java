package com.example.SalesMgmt.Controller;

import com.example.SalesMgmt.DTO.Spare_parts_typeDTO;
import com.example.SalesMgmt.Entity.Spare_parts;
import com.example.SalesMgmt.Entity.Spare_parts_type;
import com.example.SalesMgmt.Service.Spare_parts_type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Spare_parts_type_Controller{

    @Autowired
    private Spare_parts_type_Service Spare_parts_type_Service;
    private Object Spare_parts_type;

    //Post Method
    @PostMapping("/spare_parts_type/post")
    public Spare_parts_typeDTO addSpare_parts_type( @RequestBody Spare_parts_typeDTO spare_parts_type  ){
        return Spare_parts_type_Service.addSpare_parts_type(spare_parts_type);
    }
    @PostMapping("/spare_type_parts/createList")
    public List<Spare_parts_type> saveStudent(@RequestBody List<Spare_parts_type> product){
        return Spare_parts_type_Service.saveAllDetails(product);
    }

    /*//read method
    @GetMapping("/spare_parts_type/get")
    public List<Spare_parts_type> getAllDetails(){
        return Spare_parts_type_Service.listAllDetails();
    }
    //read method by ID
    @GetMapping("/spare_parts_type/getById/{id}")
    public Spare_parts_type getDetailsByID(@PathVariable int id){

        return Spare_parts_type_Service.getProductDetailsByID(id);
    }*/
    //read method
    @GetMapping("/get")
    public Page<Spare_parts_type> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                           @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return Spare_parts_type_Service.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/spare_parts_type/update")
    public Spare_parts_type updateStudent(@RequestBody Spare_parts_type spare_parts) {
        return Spare_parts_type_Service.updateProductDetails(Spare_parts_type);
    }


    //delete method+
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return Spare_parts_type_Service.deleteDetailsById(id);
    }
}

