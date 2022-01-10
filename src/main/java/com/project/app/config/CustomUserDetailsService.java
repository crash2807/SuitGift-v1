package com.project.app.config;

import com.project.app.entities.User;
import com.project.app.repositories.UserRepository;
import com.project.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
/*
    private UserService userService;

    public CustomUserDetailsService (UserService theUserService){
        userService=theUserService;
    }
*/
@Autowired
private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return new CustomUserDetails(user);
    }
    public CustomUserDetailsService(){

    }
}
