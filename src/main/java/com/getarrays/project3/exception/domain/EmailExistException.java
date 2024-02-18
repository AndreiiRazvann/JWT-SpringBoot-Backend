package com.getarrays.project3.exception.domain;

public class EmailExistException extends Exception{

    public EmailExistException(String message) {
        super(message); //call the Exception super class.
    }
}
