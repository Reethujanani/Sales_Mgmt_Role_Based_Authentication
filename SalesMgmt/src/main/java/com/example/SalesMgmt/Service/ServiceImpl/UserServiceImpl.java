package com.example.SalesMgmt.Service.ServiceImpl;

import antlr.Token;
import com.example.SalesMgmt.DTO.TokenDTO;
import com.example.SalesMgmt.DTO.UserDTO;
import com.example.SalesMgmt.Entity.Role;
import com.example.SalesMgmt.Entity.User;
import com.example.SalesMgmt.Entity.UserRole;
import com.example.SalesMgmt.Exception.UnAuthException;
import com.example.SalesMgmt.Repository.RoleRepository;
import com.example.SalesMgmt.Repository.UserRepository;
import com.example.SalesMgmt.Service.UserService;
import com.example.SalesMgmt.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    JwtUtil jwtUtil = new JwtUtil();

    @Override
    public UserDTO addUser(UserDTO user) {
        User user1 = new User();
        user1.setFirstname(user.getFirstname());
        user1.setUsername(user.getUsername());
        user1.setLastname(user.getLastname());
        user1.setMobile_no(user.getMobile_no());
        user1.setIs_active(user.getIs_active());
        user1.setPassword(user.getPassword());
        user1.setIs_deleted(user.getIs_deleted());
        List<UserRole> roleList = new LinkedList<>();
        user.getRoleList().stream().forEachOrdered(action->{
            UserRole userRole = new UserRole();
            Optional<Role> role = roleRepository.findById(action.getId());
            userRole.setRole(role.get());
            userRole.setUser(user1);
            roleList.add(userRole);
        });
        Optional<User> userCheck = userRepository.findByUsername(user.getUsername());
        if(userCheck.isPresent()){
            throw new UnAuthException("Already available");
        }
        user1.setRoleList(roleList);
        try {
            userRepository.save(user1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Page<User> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(Sort.Direction.DESC,sortBy));
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    @Override
    public UserDTO updateProductDetails(UserDTO user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setFirstname(user.getFirstname());
        user1.setUsername(user.getUsername());
        user1.setLastname(user.getLastname());
        user1.setMobile_no(user.getMobile_no());
        user1.setIs_active(user.getIs_active());
        user1.setPassword(user.getPassword());
        user1.setIs_deleted(user.getIs_deleted());
        userRepository.save(user1);
        return null;
    }
    public User getProductDetailsByID(int userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.get();
    }
        @Override
    public String deleteDetailsById(int id) {
        userRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public String login(TokenDTO tokenDTO) {
        Optional<User> Obj = userRepository.findByUsernameAndPassword(tokenDTO.getUsername(),tokenDTO.getPassword());
        String token= "";
        try
        {
            if(Obj.isPresent())
            {
                List<Role> roles = new LinkedList<>();
                Obj.get().getRoleList().stream().forEachOrdered(role->{
                    Role newRole = new Role();
                    newRole.setRoleName(role.getRole().getRoleName());
                    newRole.setId(role.getId());
                    roles.add(newRole);
                });
              token = JwtUtil.generateToken("Jwt_Token",Obj.get().getId(),roles,Obj.get().getUsername());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public UserDetails loadByUserName(String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        Set authority= authority(userName);
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),user.get().getPassword(),authority);
    }
    public Set authority(String userName){
        Optional<User> user = userRepository.findByUsername(userName);
        Set authority = new HashSet();
        user.get().getRoleList().stream().forEachOrdered(action->{
            authority.add(new SimpleGrantedAuthority("ROLE_"+action.getRole().getRoleName()));
        });
    return authority;
    }

}
