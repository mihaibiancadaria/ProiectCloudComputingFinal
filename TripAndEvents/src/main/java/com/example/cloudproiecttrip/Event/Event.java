package com.example.cloudproiecttrip.Event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Event {
    private Long idEvent;
    private String nameEvent;
    private EventType eventType;
    private String description;
    private Date startTime;
    private Date endTime;
    private boolean ticketsBought;

    public Event(Long idEvent, String nameEvent, EventType eventType, String description, Date startTime, Date endTime, boolean ticketsBought) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.eventType = eventType;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketsBought = ticketsBought;
    }

    public Event(String nameEvent, EventType eventType, String description, Date startTime, Date endTime, boolean ticketsBought) {
        this.nameEvent = nameEvent;
        this.eventType = eventType;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketsBought = ticketsBought;
    }

    public Event() {

    }
}
