package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;

public class FollowerDTO {

    private String firstName;
    private String lastName;
    private String username;

    public FollowerDTO(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.username = person.getUsername();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "FollowerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
