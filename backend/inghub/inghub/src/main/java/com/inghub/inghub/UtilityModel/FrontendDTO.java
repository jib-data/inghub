package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FrontendDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String jwt;
    private Set<FollowerDTO> followers = new HashSet<>();
    private Set<FollowerDTO> following = new HashSet<>();
    private Set<PostDTO> posts = new HashSet<>();

    public FrontendDTO(Person person, List<Post> posts, String jwt){
        this.userId = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.username = person.getUsername();
        this.jwt = jwt;
        this.followers = person.getFollowers().stream().map(follower -> new FollowerDTO(follower)).collect(Collectors.toSet());
        this.following = person.getFollowing().stream().map(following -> new FollowerDTO(following)).collect(Collectors.toSet());
        this.posts = posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toSet());


    }
    public FrontendDTO(PersonDetails person, List<Post> posts, String jwt){
        this.userId = person.getUserId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.username = person.getUsername();
        this.jwt = jwt;
        this.followers = person.getFollowers().stream().map(follower-> new FollowerDTO(follower)).collect(Collectors.toSet());
        this.following = person.getFollowing().stream().map(following-> new FollowerDTO(following)).collect(Collectors.toSet());
        this.posts = posts.stream().map(post -> new PostDTO(post)).collect(Collectors.toSet());


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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Set<FollowerDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<FollowerDTO> followers) {
        this.followers = followers;
    }

    public Set<FollowerDTO> getFollowing() {
        return following;
    }

    public void setFollowing(Set<FollowerDTO> following) {
        this.following = following;
    }

    public Set<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDTO> posts) {
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
