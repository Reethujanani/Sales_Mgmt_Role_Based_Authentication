package com.example.SalesMgmt.Repository;

import com.example.SalesMgmt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository <User, Integer>{


  Optional<User> findByUsername(String username);
  Optional<User> findByUsernameAndPassword(String username, String password);
}
