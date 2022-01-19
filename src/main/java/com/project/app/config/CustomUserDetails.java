package com.project.app.config;

import com.project.app.entities.Hobby;
import com.project.app.entities.User;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Set;

public class CustomUserDetails implements UserDetails {

    private User theUser;
    public CustomUserDetails(User user) {
        this.theUser = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return theUser.getPassword();
    }

    @Override
    public String getUsername() {
        return theUser.getEmail();
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
    public String getFullName() {
        return theUser.getName() + " " + theUser.getSurname();
    }

    public Set<Hobby> getUserHobbies(){
        return theUser.getHobbySet();
    }
}
