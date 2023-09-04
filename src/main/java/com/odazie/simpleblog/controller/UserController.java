package com.odazie.simpleblog.controller;

import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("/api")
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping( "/users" )
    public ResponseEntity< List<User> > getAllUsers()
    {
        return new ResponseEntity<>( userService.getAllUsers(), HttpStatus.OK );
    }

    @GetMapping( "/users/{id}" )
    public ResponseEntity< User > getUserById( @PathVariable( "id" ) Long userId )
    {
        return new ResponseEntity<>( userService.getUserById( userId ), HttpStatus.OK );
    }

    @PostMapping( "/users" )
    public ResponseEntity< User > createUser( @RequestBody User user )
    {
        // if user with such email or username already exists, return 409 Conflict
        if ( userService.getAllUsers().stream().anyMatch( u -> u.getEmail().equals( user.getEmail() ) ) ||
                userService.getAllUsers().stream().anyMatch( u -> u.getUsername().equals( user.getUsername() ) ) )
        {
            return new ResponseEntity<>( HttpStatus.CONFLICT );
        }

        // if user has a wrong email format, return 400 Bad Request
        // repair the regex to not accept spaces in the email
        if ( !user.getEmail().matches( "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ) )
        {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        userService.saveUser( user );
        return new ResponseEntity<>( user, HttpStatus.CREATED );
    }

    @DeleteMapping( "/users/{id}" )
    public ResponseEntity< HttpStatus > deleteUser( @PathVariable( "id" ) Long userId )
    {
        if ( userService.getUserById( userId ) == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        userService.deleteUser( userId );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @DeleteMapping( "/users" )
    public ResponseEntity< HttpStatus > deleteAllUsers()
    {
        userService.deleteAllUsers();
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
