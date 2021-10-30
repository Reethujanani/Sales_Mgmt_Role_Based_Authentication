package com.example.SalesMgmt.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class Spare_partsDTO {

    private int id;
    private String parts_name;
    private int spare_parts_type_id_fk;
    private String parts_description;
    private int is_active;
    private int is_deleted;
}
