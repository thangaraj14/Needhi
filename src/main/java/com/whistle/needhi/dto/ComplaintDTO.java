package com.whistle.needhi.dto;

import com.whistle.needhi.enums.Location;
import com.whistle.needhi.enums.Status;
import com.whistle.needhi.model.Attachment;
import com.whistle.needhi.model.Person;

import java.util.Date;

public class ComplaintDTO {

    long id;
    String description;
    Date date;
    Status status;
    Location location;
    Attachment attachment;
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

}
