package org.example.session07.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.session07.models.dto.req.PersonReq;
import org.example.session07.models.entities.Person;
import org.example.session07.models.repositories.PersonRepository;
import org.example.session07.models.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(PersonReq req) {
        Person person = Person.builder()
                .fullName(req.fullName())
                .age(req.age())
                .email(req.email())
                .build();
        return personRepository.save(person);
    }
}
