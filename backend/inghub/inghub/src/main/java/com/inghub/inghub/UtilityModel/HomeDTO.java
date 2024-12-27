package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;

import java.util.List;
import java.util.Set;

public class HomeDTO {
    Set<Person> followers;
    List<Person> users;
    List<PostDTO> posts;

    public HomeDTO(Set<Person> followers, List<Person> users, List<PostDTO> posts) {
        this.followers = followers;
        this.users = users;
        this.posts = posts;
    }

    public Set<Person> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Person> followers) {
        this.followers = followers;
    }

    public List<Person> getUsers() {
        return users;
    }

    public void setFollowing(List<Person> following) {
        this.users = users;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "HomeDTO{" +
                "followers=" + followers +
                ", users=" + users +
                ", posts=" + posts +
                '}';
    }
}
