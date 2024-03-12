package com.getarrays.project3.listener;

import com.getarrays.project3.domain.UserPrincipal;
import com.getarrays.project3.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener {
    private LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationSuccessListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) { //method that is going to fire when a user successfully provide credentials
        Object principal = event.getAuthentication().getPrincipal();
        if (principal instanceof UserPrincipal) { //checks if the principal is an instance of the User class, indicating that it's the authenticated user.
            UserPrincipal user = (UserPrincipal) event.getAuthentication().getPrincipal();
            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
        }

    }
}
