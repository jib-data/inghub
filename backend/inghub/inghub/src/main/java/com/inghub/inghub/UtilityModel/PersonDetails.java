package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDetails implements UserDetails {

   private Person person;

   public PersonDetails(Person person){
       this.person = person;
   }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can implement logic for expired accounts if needed.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can implement logic for locked accounts if needed.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can implement logic for expired credentials if needed.
    }

    @Override
    public boolean isEnabled() {
        return true; // You can implement logic for enabled/disabled accounts if needed.
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUsername();
    }
    public String getFirstName(){
       return person.getFirstName();
    }
    public String getLastName(){
       return person.getLastName();
    }
    public Set<Person> getFollowers(){
       return person.getFollowers();
    }
    public Set<Person> getFollowing(){
       return person.getFollowing();
    }
    public Long getUserId(){
       return person.getId();
    }


}
