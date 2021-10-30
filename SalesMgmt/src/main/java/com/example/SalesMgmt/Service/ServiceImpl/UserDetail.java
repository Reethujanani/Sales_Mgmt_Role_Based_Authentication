/*
package com.example.SalesMgmt.Service.ServiceImpl;


import com.example.SalesMgmt.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail extends User implements UserDetails {

    private static final long serialVersionUID = 1L;

    public UserDetail(User user)
    {
        super(user);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list= new ArrayList<SimpleGrantedAuthority>();
        return list;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword()
    {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
*/
