package com.example.SalesMgmt.DTO;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data

public class UserDTO {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mobile_no;
    private int is_active;
    private int is_deleted;

    private List<RoleDTO> roleList;


}
