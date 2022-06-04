package com.arno.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Token.class)
    @JoinColumn(name = "token_id")
    private Token tokenId;

    @Column(name = "working_position")
    private String working_position;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Organization.class)
    @JoinColumn(name = "organization_id")
    private Organization organization_id;

}
