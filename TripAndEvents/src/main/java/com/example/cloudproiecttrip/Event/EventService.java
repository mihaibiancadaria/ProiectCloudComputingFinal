package com.example.cloudproiecttrip.Event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepo eventRepo;
    private EventMapper eventMapper;

    public EventService(EventRepo eventRepo, EventMapper eventMapper) {
        this.eventRepo = eventRepo;
        this.eventMapper = eventMapper;
    }

    public EventDTO saveEvent(Event object, Long id){
        Event eventSaved= eventRepo.save(object, id);
        EventDTO event = eventMapper.entityToDto(eventSaved);
        return event;
    }

    public List<Event> getAllEvents(Long idTrip){
        return eventRepo.getAll(idTrip);
    }
}
