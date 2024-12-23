package com.inghub.inghub.UtilityService;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Repository.PersonRepository;
import com.inghub.inghub.UtilityModel.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonDetailsService implements UserDetailsService {

    PersonRepository personRepository;

    PersonDetailsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Person person = personRepository.findPersonByUsername(username);

            if (person != null){
                return new PersonDetails(person);
            } else {
                throw new UsernameNotFoundException("user not found");
            }

    }
}
