package com.koenrodenburg.springbootstarter.control;

import com.koenrodenburg.springbootstarter.entity.Person;
import com.koenrodenburg.springbootstarter.entity.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
