package com.fsse2603.lab_b01;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private List<PersonData> personDataList = new ArrayList<>();

    @PostMapping("/person/create")
    public PersonData createPerson(@RequestBody PersonData newPerson){
        personDataList.add(newPerson);
        return newPerson;
    }

    @GetMapping("/person/all")
    public List<PersonData> getAllPeople(){

        return personDataList;
    }

    @PutMapping("/person/update")
    public PersonData updatePerson(@RequestBody PersonData updatePerson){
        for(PersonData personData : personDataList){
            if(personData.getHkid().equals(updatePerson.getHkid())){
                personData.setFirstName(updatePerson.getFirstName());
                personData.setLastName(updatePerson.getLastName());
                return personData;
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/person/delete")
    public PersonData deletePerson(@RequestParam String hkid){
        for(PersonData personData : personDataList){
            if(personData.getHkid().equals(hkid)){
                //PersonData deletePerson = personData;
                personDataList.remove(personData);
                return personData;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }




}
