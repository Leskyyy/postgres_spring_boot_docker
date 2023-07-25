package com.odazie.simpleblog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "loan" )
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long loanId;

    private Float amount;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Participant owner;

}
