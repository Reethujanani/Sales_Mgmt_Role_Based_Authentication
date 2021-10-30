package com.example.SalesMgmt.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class OrderDTO {

    private int id;
    private int user_id_fk;
    private int spare_parts_id_fk;
    private int is_active;
    private int is_deleted;

}
