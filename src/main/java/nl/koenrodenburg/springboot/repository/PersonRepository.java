package nl.koenrodenburg.springboot.repository;

import nl.koenrodenburg.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
