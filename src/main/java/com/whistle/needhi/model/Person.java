package com.whistle.needhi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "phone_number")
    long phoneNumber;
/*
    @OneToMany
    @JoinColumn(name = "complaint_id")
    List<Complaint> complaints;*/

}
