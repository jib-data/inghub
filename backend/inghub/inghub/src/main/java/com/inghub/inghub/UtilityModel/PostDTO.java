package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Post;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PostDTO {

    private Long postId;
    private Long personId;
    private String personName;
    private Long postLikes;
    private String postText;
    private Set<CommentDTO> postComments = new HashSet<>();
    private LocalDateTime dateCreated;

    public PostDTO(Post post){
        this.postId = post.getPostId();
        this.personId = post.getPerson().getId();
        this.personName = post.getPerson().getFirstName() + " " + post.getPerson().getLastName();
        this.postLikes = post.getLikes();
        this.postText = post.getPostText();
        this.postComments = post.getPostComments().stream().map(comment -> new CommentDTO(comment)).collect(Collectors.toSet());
        this.dateCreated = post.getDateCreated();
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Long getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Long postLikes) {
        this.postLikes = postLikes;
    }

    public Set<CommentDTO> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<CommentDTO> postComments) {
        this.postComments = postComments;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDTO postDTO)) return false;
        return Objects.equals(postId, postDTO.postId) && Objects.equals(personId, postDTO.personId) && Objects.equals(postLikes, postDTO.postLikes) && Objects.equals(postText, postDTO.postText) && Objects.equals(postComments, postDTO.postComments) && Objects.equals(dateCreated, postDTO.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, personId, postLikes, postText, postComments, dateCreated);
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", personId=" + personId +
                ", postLikes=" + postLikes +
                ", postText='" + postText + '\'' +
                ", postComments=" + postComments +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
