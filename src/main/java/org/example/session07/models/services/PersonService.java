package org.example.session07.models.services;

import org.example.session07.models.dto.req.PersonReq;
import org.example.session07.models.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person create(PersonReq req);

}
