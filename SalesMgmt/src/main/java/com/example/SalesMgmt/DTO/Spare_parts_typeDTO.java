package com.example.SalesMgmt.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class Spare_parts_typeDTO {

    private int id;
    private String parts_type_name;
    private String parts_type_description;
    private int is_active;
    private int is_deleted;

}
