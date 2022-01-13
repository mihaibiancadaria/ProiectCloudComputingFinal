package com.example.cloudproiecttrip.Trip;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TripMapper {
    public Trip dtoToEntity(TripDTO tripDTO) {
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            startDate = sd.parse(tripDTO.getStartDate());
            endDate = sd.parse(tripDTO.getEndDate());
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return new Trip(tripDTO.getTripName(), tripDTO.getDescription(), tripDTO.getCountryName(), startDate, endDate);
    }

    public TripDTO entityToDto(Trip trip) {
        return new TripDTO(trip.getTripName(), trip.getDescription(), trip.getCountryName(), trip.getStartDate().toString(), trip.getEndDate().toString());
    }
}
