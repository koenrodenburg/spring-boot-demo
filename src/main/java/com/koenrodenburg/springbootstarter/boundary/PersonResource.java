package com.koenrodenburg.springbootstarter.boundary;

import com.koenrodenburg.springbootstarter.control.PersonService;
import com.koenrodenburg.springbootstarter.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/person")
@AllArgsConstructor
public class PersonResource {
    private final PersonService personService;

    @GetMapping(value = "/")
    public Iterable<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        Optional<Person> optionalPerson = personService.findById(id);
        return optionalPerson
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Optional<Person> optionalPerson = personService.findById(id);
        if(optionalPerson.isPresent()) {
            personService.delete(id);
            return new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}