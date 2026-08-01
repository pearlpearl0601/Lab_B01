package com.fsse2603.lab_b01;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
