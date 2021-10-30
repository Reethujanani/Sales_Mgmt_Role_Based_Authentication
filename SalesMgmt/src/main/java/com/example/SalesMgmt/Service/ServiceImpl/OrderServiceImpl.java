package com.example.SalesMgmt.Service.ServiceImpl;

import com.example.SalesMgmt.DTO.OrderDTO;
import com.example.SalesMgmt.Entity.Order;
import com.example.SalesMgmt.Entity.Spare_parts;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Repository.OrderRepository;
import com.example.SalesMgmt.Repository.Spare_partsRepository;
import com.example.SalesMgmt.Repository.UserRepository;
import com.example.SalesMgmt.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Spare_partsRepository spare_partsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO addOrder(OrderDTO order) {
        Order order1 = new Order();
        Optional<Spare_parts> spare_parts = spare_partsRepository.findById(order.getSpare_parts_id_fk());
        if (spare_parts.isPresent()) {
            order1.setSpare_parts(spare_parts.get());
        }
        Optional<User> user = userRepository.findById(order.getUser_id_fk());
        if (user.isPresent()) {
            order1.setUser(user.get());
        }

        order1.setIs_active(order.getIs_active());
        order1.setIs_deleted(order.getIs_deleted());
        try {
            orderRepository.save(order1);

            return order;}
        catch (Exception e)

        {
            e.getMessage();

        }
        return null;


    }

    @Override
    public Page<Order> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Order> order = orderRepository.findAll(pageable);
        return order;
    }

    @Override
    public Order getProductDetailsByID(int id) {
        return null;
    }

    @Override
    public List<Order> saveAllDetails(List<Order> product) {
        return null;
    }

    @Override
    public String deleteDetailsById(int id) {
        orderRepository.deleteById(id);
        return "Success";
    }

 /*   @Override
    public OrderDTO getProductDetailsByID(int id) {
        return null;
    }*/
}
