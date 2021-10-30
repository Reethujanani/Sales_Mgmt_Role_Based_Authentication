package com.example.SalesMgmt.Controller;

import com.example.SalesMgmt.DTO.Spare_partsDTO;
import com.example.SalesMgmt.Entity.Spare_parts;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Service.Spare_parts_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spare_parts")
public class Spare_parts_Controller{

    @Autowired
    private Spare_parts_Service spare_parts_Service;

    //Post Method
    @PostMapping("/post")
    public Spare_partsDTO addSpare_parts( @RequestBody Spare_partsDTO spare_parts  ){
        return spare_parts_Service.addSpare_parts(spare_parts);
    }

    //read method
    @GetMapping("/gets")
    public List<Spare_parts> getAllDetails(){
        return spare_parts_Service.listAllDetails();
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Spare_parts getDetailsByID(@PathVariable int id){

        return spare_parts_Service.getProductDetailsByID(id);
    }

    //read method
    @GetMapping("/get")
    public Page<Spare_parts> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                    @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return spare_parts_Service.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/update")
    public Spare_partsDTO updateStudent(@RequestBody Spare_partsDTO spare_parts) {
        return spare_parts_Service.updateProductDetails(spare_parts);
    }


    //delete method+
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return spare_parts_Service.deleteDetailsById(id);
    }
}


