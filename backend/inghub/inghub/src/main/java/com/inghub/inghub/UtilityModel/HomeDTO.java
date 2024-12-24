package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Person;
import com.inghub.inghub.Model.Post;

import java.util.List;
import java.util.Set;

public class HomeDTO {
    Set<Person> followers;
    Set<Person> following;
    List<PostDTO> posts;

    public HomeDTO(Set<Person> followers, Set<Person> following, List<PostDTO> posts) {
        this.followers = followers;
        this.following = following;
        this.posts = posts;
    }

    public Set<Person> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Person> followers) {
        this.followers = followers;
    }

    public Set<Person> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Person> following) {
        this.following = following;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
