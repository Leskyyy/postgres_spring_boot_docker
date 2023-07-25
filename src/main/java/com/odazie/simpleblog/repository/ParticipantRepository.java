package com.odazie.simpleblog.repository;

import com.odazie.simpleblog.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long >
{

    Participant findByParticipantId( Long participantId );

    @Override
    List< Participant > findAll();

}
