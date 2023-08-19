package com.odazie.simpleblog.seed;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.Participant;
import com.odazie.simpleblog.model.Role;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.EventRepository;
import com.odazie.simpleblog.repository.ParticipantRepository;
import com.odazie.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadEventData();
        loadParticipantData();
    }

    private void loadUserData() {
        User user1 = new User();
        user1.setEmail("john.doe@gmail.com");
        user1.setPassword("password123");
        user1.setRole(Role.USER);

        if (userRepository.findByEmail(user1.getEmail()).isEmpty()) {
            userRepository.save(user1);
        }

        User user2 = new User();
        user2.setEmail("emma.smith@yahoo.com");
        user2.setPassword("p@ssword!");
        user2.setRole(Role.USER);

        if (userRepository.findByEmail(user2.getEmail()).isEmpty()) {
            userRepository.save(user2);
        }

        User user3 = new User();
        user3.setEmail("williamj@example.com");
        user3.setPassword("securePassword");
        user3.setRole(Role.USER);

        if (userRepository.findByEmail(user3.getEmail()).isEmpty()) {
            userRepository.save(user3);
        }

        User user4 = new User();
        user4.setEmail("laura_hernandez@hotmail.com");
        user4.setPassword("myP@$$w0rd");
        user4.setRole(Role.USER);

        if (userRepository.findByEmail(user4.getEmail()).isEmpty()) {
            userRepository.save(user4);
        }

        User user5 = new User();
        user5.setEmail("alex_wong@outlook.com");
        user5.setPassword("StrongP@ssw0rd");
        user5.setRole(Role.USER);

        if (userRepository.findByEmail(user5.getEmail()).isEmpty()) {
            userRepository.save(user5);
        }
    }

    private void loadEventData() {
        Event event1 = new Event();
        event1.setName("Trip to Szklarska");

        if (eventRepository.findByName(event1.getName()).isEmpty()) {
            eventRepository.save(event1);
        }

        Event event2 = new Event();
        event2.setName("Nocny Targ");

        if (eventRepository.findByName(event2.getName()).isEmpty()) {
            eventRepository.save(event2);
        }

        Event event3 = new Event();
        event3.setName("Boys Night Out");

        if (eventRepository.findByName(event3.getName()).isEmpty()) {
            eventRepository.save(event3);
        }
    }

    private void loadParticipantData() {
        Participant participant1 = new Participant();
        participant1.setEvent(eventRepository.findByEventId(1L));
        participant1.setMyuser(userRepository.findByUserId(1L));

        if (participantRepository.findByEventAndMyuser(1L, 1L).isEmpty()) {
            participantRepository.save(participant1);
        }

        Participant participant2 = new Participant();
        participant2.setEvent(eventRepository.findByEventId(1L));
        participant2.setMyuser(userRepository.findByUserId(2L));

        if (participantRepository.findByEventAndMyuser(1L, 2L).isEmpty()) {
            participantRepository.save(participant2);
        }

        Participant participant3 = new Participant();
        participant3.setEvent(eventRepository.findByEventId(2L));
        participant3.setMyuser(userRepository.findByUserId(3L));

        if (participantRepository.findByEventAndMyuser(2L, 3L).isEmpty()) {
            participantRepository.save(participant3);
        }

        Participant participant4 = new Participant();
        participant4.setEvent(eventRepository.findByEventId(2L));
        participant4.setMyuser(userRepository.findByUserId(4L));

        if (participantRepository.findByEventAndMyuser(2L, 4L).isEmpty()) {
            participantRepository.save(participant4);
        }

        Participant participant5 = new Participant();
        participant5.setEvent(eventRepository.findByEventId(3L));
        participant5.setMyuser(userRepository.findByUserId(5L));

        if (participantRepository.findByEventAndMyuser(3L, 5L).isEmpty()) {
            participantRepository.save(participant5);
        }
    }
}
