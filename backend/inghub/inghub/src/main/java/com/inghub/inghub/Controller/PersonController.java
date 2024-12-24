package com.inghub.inghub.Controller;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;
import com.inghub.inghub.Repository.PersonRepository;
import com.inghub.inghub.Service.PersonService;
import com.inghub.inghub.Service.PostService;
import com.inghub.inghub.UtilityModel.*;
import com.inghub.inghub.UtilityService.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    JWTService jwtService;

    @Autowired
    PostService postService;

    public PersonController(PersonService personService, JWTService jwtService, PostService postService){
        this.personService = personService;
        this.jwtService = jwtService;
        this.postService = postService;
    }

    @PostMapping("/signup")
    public ResponseEntity<FrontendDTO>  signUp(@RequestBody SignupObject signupObject){
        Person newUser = personService.createUser(signupObject);
        if (newUser != null){
            String jwt = jwtService.generateJwtToken(newUser.getUsername());
            List<Post> posts = postService.getAllPost();
            FrontendDTO payload = new FrontendDTO(newUser, posts, jwt);
            return new ResponseEntity<>(payload, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.CONTINUE);
    }
    @PostMapping("/login")

    public ResponseEntity<FrontendDTO> login(@RequestBody LoginObject loginObject){
        PersonDetails personDetails = personService.loginUser(loginObject);
        if (personDetails != null){
            String jwt = jwtService.generateJwtToken(personDetails.getUsername());
            List<Post> posts = postService.getAllPost();

            return new ResponseEntity<>(new FrontendDTO(personDetails, posts, jwt), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/user")
    public ResponseEntity<Person> updateUser(@RequestBody Person person){
        Person user = personService.getById(person.getId());
        if (user != null){
            return new ResponseEntity<>(personService.updateDetails(person), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long Id){

        personService.deletePerson(Id);
        return "User successfully deleted";
    }
    @PostMapping("/follow/{followerId}/{followedId}")
    public boolean followUser(@PathVariable Long followerId, Long followedId){
        Person follower = personService.getById(followedId);
        Person followed = personService.getById(followedId);
        if(follower != null & followed != null){
            return personService.follow(followerId, followedId);
        }
        return false;
    }

    @DeleteMapping("/follow/{followerId}/followed/{followedId}")
    public boolean unfollowUser(@PathVariable Long followerId, Long followedId){
        Person follower = personService.getById(followedId);
        Person followed = personService.getById(followedId);
        if(follower != null & followed != null){
            return personService.unfollow(followerId, followedId);
        }
        return false;
    }
    @GetMapping("/{id}")
    public ResponseEntity<HomeDTO> getHomeData(@PathVariable Long id){
        System.out.println(id);
        Person person = personService.getById(id);
        Set<Person> followers = person.getFollowers();
        Set<Person> following = person.getFollowing();
        List<Post> posts = postService.getAllPost();
        List<PostDTO> postDTO = posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        HomeDTO homeDTO = new HomeDTO(followers, following, postDTO);
        return new ResponseEntity<>(homeDTO, HttpStatus.OK);
    }


}
