package com.mdwohl.codefellowship.models.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class ApplicationUser implements userDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;

    public ApplicationUser(){}

    public ApplicationUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public boolean isAccountNonExpired(){
        return false;
    }

    @Override
    public boolean isAccountNonLocked(){
        return false;
    }

    @Override
    public boolean isAccountNonExpired(){
        return false;
    }

    @Override
    public boolean isEnabled(){
        return false;
    }
}
