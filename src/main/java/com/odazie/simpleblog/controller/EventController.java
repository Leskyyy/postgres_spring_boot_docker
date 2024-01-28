package com.odazie.simpleblog.controller;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.service.EventService;
import com.odazie.simpleblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("/api")
public class EventController
{

    @Autowired
    private EventService eventService;

    @GetMapping( "/events" )
    public ResponseEntity< List<Event> > getAllEvents()
    {
        return new ResponseEntity<>( eventService.getAllEvents(), HttpStatus.OK );
    }

    @GetMapping( "/events/{id}" )
    public ResponseEntity< Event > getEventById( @PathVariable( "id" ) Long eventId )
    {
        return new ResponseEntity<>( eventService.getEventById( eventId ), HttpStatus.OK );
    }

    @PostMapping( "/events" )
    public ResponseEntity< Event > createEvent( @RequestBody Event event )
    {
        eventService.saveEvent( event );
        return new ResponseEntity<>( event, HttpStatus.CREATED );
    }

    @DeleteMapping( "/events/{id}" )
    public ResponseEntity< HttpStatus > deleteEvent( @PathVariable( "id" ) Long eventId )
    {
        if ( eventService.getEventById( eventId ) == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        eventService.deleteEvent( eventId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @DeleteMapping( "/events" )
    public ResponseEntity< HttpStatus > deleteAllEvents()
    {
        eventService.deleteAllEvents();
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
