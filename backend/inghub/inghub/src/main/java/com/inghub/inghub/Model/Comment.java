package com.inghub.inghub.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", unique = true)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

//    @ManyToOne
//    @JoinColumn(name = "person_id")
//    private Person person;

    @Column(name = "comment_text")
    @Lob
    private String commentText;
    @Column(name = "comment_likes")
    private Long commentLikes = 0l;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;


    public Comment() {
    }

    public Comment(Post post, String commentText, LocalDateTime dateCreated) {
        this.post = post;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
    }

    public Comment(Long commentId, String commentText, LocalDateTime dateCreated) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(Long commentLikes) {
        this.commentLikes = commentLikes;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
//    public Person getPerson() {
//        return person;
//    }

//    public void setPerson(Person person) {
//        this.person = person;
//    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", post=" + post +
                ", commentText='" + commentText + '\'' +
                ", commentLikes=" + commentLikes +
                ", dateCreated=" + dateCreated +
                '}';
    }

}
