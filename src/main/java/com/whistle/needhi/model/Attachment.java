package com.whistle.needhi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attachment {


    @Id
    @Column(name = "ATTACHMENT_KEY", nullable = false)
    String id;

    @Column(name = "format", nullable = false)
    String format;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
