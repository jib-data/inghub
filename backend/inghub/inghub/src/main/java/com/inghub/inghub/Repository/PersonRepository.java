package com.inghub.inghub.Repository;

import com.inghub.inghub.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByUsername(String Username);
}
