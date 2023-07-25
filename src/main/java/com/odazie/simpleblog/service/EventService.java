package com.odazie.simpleblog.service;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.EventRepository;
import com.odazie.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService
{

    @Autowired
    private EventRepository eventRepository;

    public void saveEvent( Event event )
    {
        eventRepository.save( event );
    }

    public List< Event > getAllEvents()
    {
        return eventRepository.findAll();
    }

    public Event getEventById(Long aEventId) {
        return eventRepository.findByEventId(aEventId);
    }

    public void deleteEvent(Long aEventId) {
        eventRepository.deleteById(aEventId);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}
