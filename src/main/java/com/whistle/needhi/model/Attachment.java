package com.whistle.needhi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
public class Attachment {

    @Id
    @Column(name = "ATTACHMENT_KEY", nullable = false)
    long id;

    @Column(name = "format", nullable = false)
    String format;

    @OneToOne
    @JoinColumn(name = "complaint_id")
    Complaint complaint;

}
