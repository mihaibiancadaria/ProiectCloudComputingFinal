package com.example.cloudproiecttrip.Event;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class EventDTO {
    @NotNull
    private String nameEvent;
    private EventType eventType;
    private String description;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;
    private boolean ticketsBought;

    public EventDTO(String numeEvent, EventType eventType, String description, String startTime, String endTime, boolean ticketsBought) {
        this.nameEvent = numeEvent;
        this.eventType = eventType;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketsBought = ticketsBought;
    }

    public EventDTO() {

    }
}
