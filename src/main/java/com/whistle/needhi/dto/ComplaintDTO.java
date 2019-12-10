package com.whistle.needhi.dto;

import com.whistle.needhi.enums.Location;
import com.whistle.needhi.enums.Status;
import com.whistle.needhi.model.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ComplaintDTO {

    long id;
    String description;
    Date date;
    Status status;
    String place;
    Location location;
    byte[] image;
    Person person;
}
