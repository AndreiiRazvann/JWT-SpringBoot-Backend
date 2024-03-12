package com.getarrays.project3.listener;

import com.getarrays.project3.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class AuthenticationFailureListener { //this fires everytime a user fails to login into the application
    private LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationFailureListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) throws ExecutionException { //method that is going to fire when a user fails to provide credentials
        Object principal = event.getAuthentication().getPrincipal(); //retrieves the principal (username) associated with the failed authentication attempt from the event.
        if (principal instanceof String) { //Principal must be a username
            String username = (String) event.getAuthentication().getPrincipal();
            loginAttemptService.addUserToLoginAttemptCache(username); //once we have the user, we add it in the loginAttemptService..we count the number of logins
        }
    }
}
