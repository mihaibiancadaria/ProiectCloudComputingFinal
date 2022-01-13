package com.example.cloudproiecttrip.Trip;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TripDTO {
    @NotBlank
    private String tripName;
    private String description;
    @NotNull
    private Country countryName;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;

    public TripDTO(String tripName, String description, Country countryName, String startDate, String endDate) {
        this.tripName = tripName;
        this.description = description;
        this.countryName = countryName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TripDTO() {

    }
}
