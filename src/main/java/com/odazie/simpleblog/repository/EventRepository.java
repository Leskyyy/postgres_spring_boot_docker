package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long >
{

    Event findByEventId( Long eventId );

    @Override
    List< Event > findAll();

    Optional<Event> findByName(String name );

}
