package com.whistle.needhi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Advertisement {

    @Id
    @Column(name = "id", nullable = false)
    String id;

    @Column(name = "format", nullable = false)
    String format;
}
