package com.example.cloudproiecttrip.utils;

public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException(Long id) {
        super("Trip with id " + id + " doesn't exist ");
    }
}
