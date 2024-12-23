package com.inghub.inghub.Controller;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;
import com.inghub.inghub.Repository.PostRepository;
import com.inghub.inghub.Service.PersonService;
import com.inghub.inghub.Service.PostService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

    private PostService postService;
    private PersonService personService;

    public PostController(PostService postService, PersonService personService) {
        this.postService = postService;
        this.personService = personService;
    }

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Long personId = post.getPerson().getId();
        Person person = personService.getById(personId);
        if(person !=null){
            post.setDateCreated(LocalDateTime.now());
            post.setPerson(person);
            return new ResponseEntity<>(postService.addPost(post), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
    @PutMapping("/post")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        Post updatedPost = postService.updatePost(post);
        if (updatedPost != null){
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
