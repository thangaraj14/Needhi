package com.whistle.needhi.model;

import com.whistle.needhi.enums.Location;
import com.whistle.needhi.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Setter
@Getter
public class Complaint extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "complaint_id")
    long id;

    @Column(name = "description", length = 2048)
    String description;

    @Column(name = "place")
    String place;

    @Temporal(TemporalType.DATE)
    @Column(name = "complaint_date")
    Date date;

    @Enumerated(EnumType.STRING)
    @Column
    Status status;

    @Enumerated(EnumType.STRING)
    @Column
    Location location;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @Lob
    @Column(name = "image")
    @Type(type = "org.hibernate.type.BinaryType")
    byte[] image;

    @Column(name = "likes")
    int likes;

}
