package com.mdwohl.codefellowship.models.user;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dob;
    public String bio;

    public ApplicationUser(String username, String password, String firstName, String lastName, Date dob, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.bio = bio;
    }

    public ApplicationUser(){};
    public String getLastName(){return this.lastName;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
}
