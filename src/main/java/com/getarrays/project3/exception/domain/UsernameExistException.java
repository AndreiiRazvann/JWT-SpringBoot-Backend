package com.getarrays.project3.exception.domain;

public class UsernameExistException extends Exception{

    public UsernameExistException(String message) {
        super(message); //call the Exception super class.
    }
}
