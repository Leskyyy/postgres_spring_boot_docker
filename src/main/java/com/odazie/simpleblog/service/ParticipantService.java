package com.odazie.simpleblog.service;

import com.odazie.simpleblog.model.Participant;
import com.odazie.simpleblog.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService
{

    @Autowired
    private ParticipantRepository participantRepository;

    public void saveParticipant( Participant participant )
    {
        participantRepository.save( participant );
    }

    public List< Participant > getAllParticipants()
    {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long aParticipantId) {
        return participantRepository.findByParticipantId(aParticipantId);
    }

    public void deleteParticipant(Long aParticipantId) {
        participantRepository.deleteById(aParticipantId);
    }

    public void deleteAllParticipants() {
        participantRepository.deleteAll();
    }
}
