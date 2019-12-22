package com.whistle.needhi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonDTO {

    long id;
    String name;
    long phoneNumber;
    String houseNumber;
    String streetName;
    String location;
    String role;

}
