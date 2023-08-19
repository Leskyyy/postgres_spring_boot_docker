package com.odazie.simpleblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "participant" )
@Getter
@Setter
public class Participant {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long participantId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> listOfLoans = new ArrayList<>();

    @JsonIgnoreProperties("listOfParticipants")
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonIgnoreProperties("authorities")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User myuser;

}
