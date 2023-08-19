package com.odazie.simpleblog.seed;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.Participant;
import com.odazie.simpleblog.model.Role;
import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.EventRepository;
import com.odazie.simpleblog.repository.ParticipantRepository;
import com.odazie.simpleblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ParticipantRepository participantRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadEventData();
        loadParticipantData();
    }

    private void loadUserData() {
        User user1 = new User();
        user1.setEmail("john.doe@gmail.com");
        user1.setPassword(passwordEncoder.encode("password123"));
        user1.setRole(Role.USER);

        if (userRepository.findByEmail(user1.getEmail()).isEmpty()) {
            userRepository.save(user1);
        }

        User user2 = new User();
        user2.setEmail("emma.smith@yahoo.com");
        user2.setPassword(passwordEncoder.encode("p@ssword!"));
        user2.setRole(Role.USER);

        if (userRepository.findByEmail(user2.getEmail()).isEmpty()) {
            userRepository.save(user2);
        }

        User user3 = new User();
        user3.setEmail("williamj@example.com");
        user3.setPassword(passwordEncoder.encode("securePassword"));
        user3.setRole(Role.USER);

        if (userRepository.findByEmail(user3.getEmail()).isEmpty()) {
            userRepository.save(user3);
        }

        User user4 = new User();
        user4.setEmail("laura_hernandez@hotmail.com");
        user4.setPassword(passwordEncoder.encode("myP@$$w0rd"));
        user4.setRole(Role.USER);

        if (userRepository.findByEmail(user4.getEmail()).isEmpty()) {
            userRepository.save(user4);
        }

        User user5 = new User();
        user5.setEmail("alex_wong@outlook.com");
        user5.setPassword(passwordEncoder.encode("StrongP@ssw0rd"));
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
        participant1.setEvent(eventRepository.findByName("Trip to Szklarska").get());
        participant1.setMyuser(userRepository.findByEmail("john.doe@gmail.com").get());

        if (participantRepository.findByEventAndMyuser(participant1.getEvent().getEventId(), participant1.getMyuser().getUserId()).isEmpty()) {
            participantRepository.save(participant1);
        }

        Participant participant2 = new Participant();
        participant2.setEvent(eventRepository.findByName("Trip to Szklarska").get());
        participant2.setMyuser(userRepository.findByEmail("emma.smith@yahoo.com").get());

        if (participantRepository.findByEventAndMyuser(participant2.getEvent().getEventId(), participant2.getMyuser().getUserId()).isEmpty()) {
            participantRepository.save(participant2);
        }

        Participant participant3 = new Participant();
        participant3.setEvent(eventRepository.findByName("Nocny Targ").get());
        participant3.setMyuser(userRepository.findByEmail("williamj@example.com").get());

        if (participantRepository.findByEventAndMyuser(participant3.getEvent().getEventId(), participant3.getMyuser().getUserId()).isEmpty()) {
            participantRepository.save(participant3);
        }

        Participant participant4 = new Participant();
        participant4.setEvent(eventRepository.findByName("Nocny Targ").get());
        participant4.setMyuser(userRepository.findByEmail("laura_hernandez@hotmail.com").get());

        if (participantRepository.findByEventAndMyuser(participant4.getEvent().getEventId(), participant4.getMyuser().getUserId()).isEmpty()) {
            participantRepository.save(participant4);
        }

        Participant participant5 = new Participant();
        participant5.setEvent(eventRepository.findByName("Boys Night Out").get());
        participant5.setMyuser(userRepository.findByEmail("alex_wong@outlook.com").get());

        if (participantRepository.findByEventAndMyuser(participant5.getEvent().getEventId(), participant5.getMyuser().getUserId()).isEmpty()) {
            participantRepository.save(participant5);
        }
    }
}
