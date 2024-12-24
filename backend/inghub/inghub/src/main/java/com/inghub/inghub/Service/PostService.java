package com.inghub.inghub.Service;


import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;
import com.inghub.inghub.Repository.PostRepository;
import com.inghub.inghub.UtilityModel.PostDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

//    1 Add post
//    2 Update post
//    3 Delete Post
//    4 Like post

    PostRepository postRepository;
    PersonService personService;

    public PostService(PostRepository postRepository, PersonService personService){
        this.postRepository = postRepository;
        this.personService = personService;
    }

    public PostDTO addPost(Post post){
        Post newPost =  postRepository.save(post);
        PostDTO postDTO = new PostDTO(newPost);
        System.out.println(postDTO);
        return postDTO;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public Post getPostById(Long id){
         Optional<Post> post= postRepository.findById(id);
         if (post.isPresent()){
             return post.get();
         }
         return null;
    }

    public Post updatePost(Post updatedPost)  {
       Optional<Post> post = postRepository.findById(updatedPost.getPostId());
       if (post.isPresent()){
           Post existingPost = post.get();
           existingPost.setPostText(updatedPost.getPostText());
           existingPost.setDateCreated(LocalDateTime.now());
           postRepository.save(existingPost);
           return existingPost;
       } else {
           return null;
       }
    }

    public void deletePost(Long id){
       Optional<Post> post = postRepository.findById(id);
       postRepository.delete(post.get());
    }
}
