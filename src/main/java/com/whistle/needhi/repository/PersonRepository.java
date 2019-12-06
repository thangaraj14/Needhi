package com.whistle.needhi.repository;

import com.whistle.needhi.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
