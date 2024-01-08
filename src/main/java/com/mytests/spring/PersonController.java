package com.mytests.spring;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;

import java.util.ArrayList;
import java.util.List;

@Controller("/person")
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Get("/all")
    public List<String> getAll() {

        personRepository.customSave("eugene", "petrov", 75);
       personRepository.customSave("pavel", "pavlov", 18);
       personRepository.customSave("alex", "petrov", 18);
       personRepository.customSave("gleb", "petrov", 30);
        List<String> rez = new ArrayList<>();

        for (Person person : personRepository.findAll()) {
            rez.add(person.toString());
        }
        return rez;
    }


    @Put("/retiredToDefault")
    public List<String> updateRetired(){
        List<String> rez = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            personRepository.updateRetired(person.getId(),false);
        }
        for (Person person : personRepository.findAll()) {
            rez.add(person.toString());
        }
        return rez;
    }
    @Put("/correctRetired")
    public List<String> correctRetiredByAge(){
        List<String> rez = new ArrayList<>();
        personRepository.updateRetiredByAgeGreaterThan(65,true);
        for (Person person : personRepository.findAll()) {
            rez.add(person.toString());
        }
        return rez;
    }

    @Put("/correctByLastName/{arg1}+{arg2:\\d+}")
    public List<String> updateAgeByLastNameReturning(@PathVariable String arg1, @PathVariable int arg2){
        List<String> rez = new ArrayList<>();
        for (Person person : personRepository.updateAgeBySurnameReturning(arg1, arg2)) {
            rez.add(person.toString());
        }

        return rez;
    }
}
