package com.inghub.inghub.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", unique = true)
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @Column(name = "post_likes")
    private Long likes = 0l;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> postComments = new HashSet<>();
    @Column(name = "post_text")
    @Lob
    private String postText;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;


    public Post() {
    }

    public Post(Person person, String postText, LocalDateTime dateCreated){
        this.person = person;
        this.postText = postText;
        this.dateCreated = dateCreated;
    }

    public Post(Long postId, Person person, String postText, Set<Comment> postComments, LocalDateTime dateCreated) {
        this.postId = postId;
        this.person = person;
        this.postText = postText;
        this.postComments = postComments;
        this.dateCreated = dateCreated;

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<Comment> postComments) {
        this.postComments = postComments;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(postId, post.postId) && Objects.equals(person, post.person) && Objects.equals(likes, post.likes) && Objects.equals(postComments, post.postComments) && Objects.equals(postText, post.postText) && Objects.equals(dateCreated, post.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, person, likes, postComments, postText, dateCreated);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", person=" + person +
                ", likes=" + likes +
                ", postComments=" + postComments +
                ", postText='" + postText + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
