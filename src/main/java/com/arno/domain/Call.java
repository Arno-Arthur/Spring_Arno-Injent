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
@Table(name = "call")

public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "edit_card_date")
    private String edit_card_date;

    @Column(name = "reason")
    private String reason;

    @Column(name = "bcc")
    private String bcc;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "residence")
    private String residence;

    @Column(name = "phone_number")
    private int phone_number;


}
