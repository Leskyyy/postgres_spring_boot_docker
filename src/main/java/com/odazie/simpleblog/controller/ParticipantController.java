package com.odazie.simpleblog.controller;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.Participant;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.service.EventService;
import com.odazie.simpleblog.service.ParticipantService;
import com.odazie.simpleblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:8081" )
@RestController
@RequestMapping("/api")
public class ParticipantController
{

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping( "/participants" )
    public ResponseEntity< List<Participant> > getAllParticipants()
    {
        return new ResponseEntity<>( participantService.getAllParticipants(), HttpStatus.OK );
    }

    @GetMapping( "/participants/{id}" )
    public ResponseEntity< Participant > getParticipantById( @PathVariable( "id" ) Long participantId )
    {
        return new ResponseEntity<>( participantService.getParticipantById( participantId ), HttpStatus.OK );
    }

    @PostMapping( "/participants" )
    public ResponseEntity< Participant > createParticipant( @RequestBody Participant participant )
    {
        Long eventId = participant.getEvent().getEventId();
        Long userId = participant.getMyuser().getUserId();

        Event event = eventService.getEventById( eventId );
        User user = userService.getUserById( userId );

        // if event or user does not exist, return 404 Not Found
        if ( event == null || user == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }

        // if participant already exists, return 409 Conflict
        if ( participantService.getAllParticipants().stream().anyMatch( p -> p.getMyuser().getUserId().equals( userId ) &&
                p.getEvent().getEventId().equals( eventId ) ) )
        {
            return new ResponseEntity<>( HttpStatus.CONFLICT );
        }

        participant.setEvent( event );
        participant.setMyuser( user );

        participantService.saveParticipant( participant );
        return new ResponseEntity<>( participant, HttpStatus.CREATED );

    }

    @DeleteMapping( "/participants/{id}" )
    public ResponseEntity< HttpStatus > deleteParticipant( @PathVariable( "id" ) Long participantId )
    {
        if ( participantService.getParticipantById( participantId ) == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        participantService.deleteParticipant( participantId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @DeleteMapping( "/participants" )
    public ResponseEntity< HttpStatus > deleteAllParticipants()
    {
        participantService.deleteAllParticipants();
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
