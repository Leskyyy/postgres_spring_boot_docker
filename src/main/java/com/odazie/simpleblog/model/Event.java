package com.odazie.simpleblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "event" )
@Getter
@Setter
public class Event
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long eventId;

    private String name;

    @JsonIgnoreProperties("event")
    @OneToMany(mappedBy = "event")
    private List<Participant> listOfParticipants;
}