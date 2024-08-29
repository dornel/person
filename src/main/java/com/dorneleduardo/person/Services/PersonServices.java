package com.dorneleduardo.person.Services;

import com.dorneleduardo.person.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public Person create(Person person){
        logger.info("Adding new person");
        return person;

    }

    public Person update(Person person){
        logger.info("Updating person");
        return person;

    }

    public void delete(String id){
        logger.info("Deleting person");


    }



    public List<Person> findAll(){

        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){

            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;


    }

    private Person mockPerson(int i) {


        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Person last name" + i);
        person.setAddress("Paper Street - 33");
        person.setGender("Male");
        return person;


    }

    public Person findById(String id){

        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eduardo");
        person.setLastName("Dornel");
        person.setAddress("Paper Street - 33");
        person.setGender("Male");
        return person;

    }


}
