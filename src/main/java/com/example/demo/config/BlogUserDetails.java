package com.example.demo.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.Collection;

public class BlogUserDetails extends User implements UserDetails{

    private ArrayList<String> roles;
    private User user;

    public BlogUserDetails(User user, ArrayList<String> roles) {
        super(user.getEmail(), user.getFullName(), user.getPassword(), user.getImage());// + 1 field
        this.roles = roles;
        this.user = user;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        String userRoles = StringUtils.collectionToCommaDelimitedString(this.roles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRoles);
    }

    @Override
    public String getUsername() {
        return user.getFullName();
        // can be changed.. not sure ...
    }

    public User getUser(){
        return this.user;
    }
}
