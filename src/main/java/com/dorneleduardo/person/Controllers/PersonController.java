package com.dorneleduardo.person.Controllers;



import com.dorneleduardo.person.Model.Person;
import com.dorneleduardo.person.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;


@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonServices service ;


    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){

        return service.findAll();

    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id){

    return service.findById(id);


    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person
    ){

        return service.create(person);


    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person
    ){

        return service.update(person);


    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){

        service.delete(id);


    }


}
