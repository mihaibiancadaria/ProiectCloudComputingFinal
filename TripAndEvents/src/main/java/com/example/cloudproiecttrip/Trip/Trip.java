package com.example.cloudproiecttrip.Trip;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Trip {
    private Long idTrip;
    private String tripName;
    private String description;
    private Country countryName;
    private Date startDate;
    private Date endDate;

    public Trip(Long idTrip, String tripName, String description, Country countryName, Date startDate, Date endDate) {
        this.idTrip = idTrip;
        this.tripName = tripName;
        this.description = description;
        this.countryName = countryName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trip(String tripName, String description, Country countryName, Date startDate, Date endDate) {
        this.tripName = tripName;
        this.description = description;
        this.countryName = countryName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trip() {

    }
}
