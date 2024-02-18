package com.getarrays.project3.service;

import com.getarrays.project3.domain.User;
import com.getarrays.project3.exception.domain.EmailExistException;
import com.getarrays.project3.exception.domain.UserNotFoundException;
import com.getarrays.project3.exception.domain.UsernameExistException;

import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistException, UsernameExistException;
    List<User> getUsers();
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
