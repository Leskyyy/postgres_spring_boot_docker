package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long >
{

    Participant findByParticipantId( Long participantId );

    @Override
    List< Participant > findAll();

    @Query("SELECT p FROM Participant p WHERE p.event.eventId = ?1 AND p.myuser.userId = ?2")
    Optional<Participant> findByEventAndMyuser(Long eventId, Long userId);

}
