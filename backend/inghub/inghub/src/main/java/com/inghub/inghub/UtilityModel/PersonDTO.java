package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDTO {
    private Long Id;
    private String firstName;
    private String lastName;
    private Set<Person> followers = new HashSet<>();
    private Set<Person> following = new HashSet<>();

    public PersonDTO(Person person){
        this.Id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.followers = person.getFollowers();
        this.following = person.getFollowing();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
