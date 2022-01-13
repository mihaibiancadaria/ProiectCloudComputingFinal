package com.example.cloudproiecttrip.Event;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EventMapper {
    public Event dtoToEntity(EventDTO eventDTO){
        Date startTime = null;
        Date endTime = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        try {
            startTime = sd.parse(eventDTO.getStartTime());
            endTime = sd.parse(eventDTO.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Event(eventDTO.getNameEvent(), eventDTO.getEventType(), eventDTO.getDescription(), startTime, endTime, eventDTO.isTicketsBought());
    }

    public EventDTO entityToDto(Event event){
        return new EventDTO(event.getNameEvent(), event.getEventType(), event.getDescription(), event.getStartTime().toString(), event.getEndTime().toString(), event.isTicketsBought());
    }
}
