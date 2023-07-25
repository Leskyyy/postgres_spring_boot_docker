package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.Event;
import com.odazie.simpleblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long >
{

    Event findByEventId( Long eventId );

    @Override
    List< Event > findAll();

}
