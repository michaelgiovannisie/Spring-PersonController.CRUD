package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person p) {
        return repository.save(p);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersonList() {
        return (List<Person>) repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable Long id, @RequestBody Person p) {
        Person x = repository.findOne(id);
        x.setLastName(p.getLastName());
        x.setFirstName(p.getFirstName());
        return repository.save(x);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id) {
        repository.delete(id);
    }
}
