package com.inghub.inghub.Service;

import com.inghub.inghub.Model.Comment;
import com.inghub.inghub.Model.Post;
import com.inghub.inghub.Repository.CommentRepository;
import com.inghub.inghub.Repository.PostRepository;
import com.inghub.inghub.UtilityModel.CommentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;
    PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService){
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment addComment(Comment comment){
        Long postId = comment.getPost().getPostId();
        if(postId != null){
            Post post = postService.getPostById(postId);
            comment.setPost(post);
            comment.setDateCreated(LocalDateTime.now());
            return commentRepository.save(comment);
        }
        return null;
    }

    public CommentDTO updateComment(Comment updatedComment){
        Optional<Comment> comment = commentRepository.findById(updatedComment.getCommentId());
        if (comment.isPresent()){
            Comment existingComment = comment.get();
            existingComment.setCommentText(updatedComment.getCommentText());
            existingComment.setDateCreated(LocalDateTime.now());
            return new CommentDTO(existingComment);
        }
        return null;
    }
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
