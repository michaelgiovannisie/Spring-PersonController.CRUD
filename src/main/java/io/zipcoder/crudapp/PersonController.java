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

    private Person person;
    private List<Person> people = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person p) {
        people.add(p);
        return p;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        for(Person x : people) {
            if(x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersonList() {
        return people;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatPerson(@PathVariable value = /"{id}" , @RequestBody Person p) {
        for(Person x : people) {
            if(x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable int id) {

    }
}
