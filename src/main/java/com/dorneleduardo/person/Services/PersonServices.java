package com.dorneleduardo.person.Services;

import com.dorneleduardo.person.Exceptions.ResourceNotFoundException;
import com.dorneleduardo.person.Model.Person;
import com.dorneleduardo.person.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        logger.info("Adding new person");
        return repository.save(person);

    }

    public Person update(Person person){
        logger.info("Updating person");

       var entity =  repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not Found"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());

        return repository.save(person);

    }

    public void delete(Long id){

        logger.info("Deleting person");
        var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not Found"));
    repository.delete(entity);

    }



    public List<Person> findAll(){

        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();

        return repository.findAll();


    }



    public Person findById(Long id){

        logger.info("Finding one person");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not Found"));

    }


}
