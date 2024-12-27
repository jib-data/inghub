package com.inghub.inghub.Service;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Repository.PersonRepository;
import com.inghub.inghub.Repository.PostRepository;
import com.inghub.inghub.UtilityModel.LoginObject;
import com.inghub.inghub.UtilityModel.PersonDetails;
import com.inghub.inghub.UtilityModel.SignupObject;
import com.inghub.inghub.UtilityService.PassEncryptService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    PassEncryptService passEncryptService;
    PersonRepository personRepository;
    PostRepository postRepository;
    AuthenticationManager authenticationManager;


    public PersonService(PersonRepository personRepository, PassEncryptService passEncryptService, PostRepository postRepository, AuthenticationManager authenticationManager){
        this.personRepository = personRepository;
        this.passEncryptService = passEncryptService;
        this.postRepository = postRepository;
        this.authenticationManager = authenticationManager;
    }

    public Person createUser(SignupObject signupObject){
        Person existingUser = personRepository.findPersonByUsername(signupObject.getUsername());
        if(!( existingUser == null)){
            return null;
        }

        Person newUser = new Person(signupObject.getFirstName(),
                signupObject.getLastName(), signupObject.getUsername(),
                passEncryptService.encryptPassword(signupObject.getPassword()), signupObject.getEmail(), signupObject.getDateOfBirth());

        return personRepository.save(newUser);
    }

    public PersonDetails loginUser(LoginObject loginObject){

        Authentication authentication;
        try {
            System.out.println(loginObject);

            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginObject.getUsername(), loginObject.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
            return personDetails;
        } catch (AuthenticationException e){
            return null;
        }

    }

    public void deletePerson(Long id){
//        Logic is, delete person and all posts of the person;
        personRepository.deleteById(id);
        postRepository.deleteById(id);
    }
    public Person getById(Long id){
       Optional<Person>  person = personRepository.findById(id);
       if(person.isPresent()){
           return person.get();
       }
       return null;
    }
    public Person updateDetails(Person person){
        System.out.println(person);
       Optional<Person> account = personRepository.findById(person.getId());
       if(account.isPresent()){
           Person existingAccount = account.get();
           existingAccount.setFirstName(person.getFirstName());
           System.out.println(person.getLastName());
           existingAccount.setLastName(person.getLastName());
           existingAccount.setUsername(person.getUsername());
           existingAccount.setPassword(passEncryptService.encryptPassword(person.getPassword()));
           existingAccount.setEmail(person.getEmail());
           personRepository.save(existingAccount);


           return existingAccount;
       }
        return null;
    }
    public boolean follow(Long followerId, Long followedId){
        Optional<Person> followedUser = personRepository.findById(followedId);
        Optional<Person> follower = personRepository.findById(followerId);
        if(follower.isPresent() && followedUser.isPresent()){
            Person followerUser = follower.get();
            followedUser.get().getFollowers().add(followerUser);
            return true;
        }
        return false;
    }
    public boolean unfollow(Long followerId, Long followedId){
        Optional<Person> followedUser = personRepository.findById(followedId);
        Optional<Person> follower = personRepository.findById(followerId);
        if(follower.isPresent() && followedUser.isPresent()){
            Person followerUser = follower.get();
            followedUser.get().getFollowers().remove(followerUser);
            return true;
        }
        return false;
    }
    public List<Person> getUsers(){
        List<Person> users = personRepository.findAll();

        return users;
    }
}
