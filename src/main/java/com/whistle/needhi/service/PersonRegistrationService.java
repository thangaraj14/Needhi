package com.whistle.needhi.service;

import com.whistle.needhi.dto.PersonDTO;
import com.whistle.needhi.model.Person;
import com.whistle.needhi.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonRegistrationService {

    @Autowired
    PersonRepository personRepository;

    Logger logger = LoggerFactory.getLogger(PersonRegistrationService.class);

    public List<Person> getAllPeople() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    public long saveOrUpdate(PersonDTO personDTO) {

        Person person = personRepository.save(toEntity(personDTO));
        if(person==null) return -1;
        return person.getId();
    }

    public Optional<Person> getPerson(long id) {
        return personRepository.findById(id);
    }

    public void delete(long id) {
        personRepository.deleteById(id);
    }

    private Person toEntity(PersonDTO dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setPhoneNumber(dto.getPhoneNumber());
        return person;
    }
}
