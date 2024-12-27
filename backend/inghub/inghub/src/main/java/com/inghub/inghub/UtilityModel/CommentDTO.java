package com.inghub.inghub.UtilityModel;

import com.inghub.inghub.Model.Comment;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDTO {

    private Long commentId;
    private Long postId;
//    private String personName;
    private String commentText;
    private Long commentLikes;
    private LocalDateTime dateCreated;

    public CommentDTO(Comment comment){
        this.commentId = comment.getCommentId();
        this.postId = comment.getPost().getPostId();
        this.commentText = comment.getCommentText();
        this.commentLikes = comment.getCommentLikes();
        this.dateCreated = comment.getDateCreated();
//        this.personName = comment.getPerson().getFirstName() + " " + comment.getPerson().getLastName();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
//    public String getPersonName() {
//        return personName;
//    }

//    public void setPersonName(String personName) {
//        this.personName = personName;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDTO that)) return false;
        return Objects.equals(commentId, that.commentId) && Objects.equals(postId, that.postId) && Objects.equals(commentText, that.commentText) && Objects.equals(commentLikes, that.commentLikes) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commentText, commentLikes, dateCreated);
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commentText='" + commentText + '\'' +
                ", commentLikes=" + commentLikes +
                ", dateCreated=" + dateCreated +
                '}';
    }


}
