package com.odazie.simpleblog.seed;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.EventRepository;
import com.odazie.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner
{

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public void run( String ... args ) throws Exception
    {
        loadUserData();
        loadEventData();
    }

    private void loadUserData()
    {
        User user1 = new User();
        user1.setEmail( "john.doe@gmail.com" );
        user1.setUsername( "johndoe" );
        user1.setPassword( "password123" );

        User user2 = new User();
        user2.setEmail( "emma.smith@yahoo.com" );
        user2.setUsername( "emmas" );
        user2.setPassword( "p@ssword!" );

        User user3 = new User();
        user3.setEmail( "williamj@example.com" );
        user3.setUsername( "willj" );
        user3.setPassword( "securePassword" );

        User user4 = new User();
        user4.setEmail( "laura_hernandez@hotmail.com" );
        user4.setUsername( "laurah" );
        user4.setPassword( "myP@$$w0rd" );

        User user5 = new User();
        user5.setEmail( "alex_wong@outlook.com" );
        user5.setUsername( "alexwong" );
        user5.setPassword( "StrongP@ssw0rd" );

        userRepository.saveAll( List.of( user1, user2, user3, user4, user5 ) );
    }

    private void loadEventData()
    {
        Event event1 = new Event();
        event1.setName( "Trip to Szklarska" );

        Event event2 = new Event();
        event2.setName("Nocny Targ");

        Event event3 = new Event();
        event3.setName("Boys Night Out");

        eventRepository.saveAll( List.of( event1, event2, event3 ) );
    }
}
