package com.project.app;

import com.project.app.entities.User;
import com.project.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFascade {

    @Autowired
    private UserService userService;
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    public User getAuthenticatedUser() {
        String email = this.getAuthentication().getName();
        return userService.findByEmail(email);
    }
}
