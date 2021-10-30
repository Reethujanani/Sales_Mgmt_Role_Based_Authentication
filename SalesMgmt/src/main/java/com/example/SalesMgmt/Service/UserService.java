package com.example.SalesMgmt.Service;

import com.example.SalesMgmt.DTO.TokenDTO;
import com.example.SalesMgmt.DTO.UserDTO;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO user);

    Page<User> listAllDetails(int pageNo , int pageSize, String sortBy);

    User getProductDetailsByID(int id);

    UserDTO updateProductDetails(UserDTO product);

    String deleteDetailsById(int id);

    String login(TokenDTO tokenDTO);

    UserDetails loadByUserName(String userName);
}
