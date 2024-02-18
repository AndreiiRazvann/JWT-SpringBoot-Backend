package com.getarrays.project3.exception.domain;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message); //call the Exception super class.
    }
}
