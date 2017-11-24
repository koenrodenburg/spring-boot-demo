package nl.koenrodenburg.springboot.controller;

import nl.koenrodenburg.springboot.model.Person;
import nl.koenrodenburg.springboot.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    public List<Person> list() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    public Person create(Person wreck) {
        return personRepository.saveAndFlush(wreck);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.PUT)
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        Person existing = personRepository.findOne(id);
        BeanUtils.copyProperties(person, existing);
        return personRepository.saveAndFlush(existing);
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE)
    public Person delete(@PathVariable Long id) {
        Person person = personRepository.findOne(id);
        personRepository.delete(person);
        return person;
    }
}
