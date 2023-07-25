package com.odazie.simpleblog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table( name = "myuser" )
@Getter
@Setter
public class User
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long userId;

    @NotBlank
    @Email( message = "Invalid email address" )
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany( mappedBy = "myuser" )
    private List< Participant > eventParticipants;

}
