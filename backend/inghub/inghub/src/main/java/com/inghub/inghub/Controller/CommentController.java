package com.inghub.inghub.Controller;

import com.inghub.inghub.Model.Comment;
import com.inghub.inghub.Repository.CommentRepository;
import com.inghub.inghub.Service.CommentService;
import com.inghub.inghub.UtilityModel.CommentDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment){
        System.out.println(comment);
        Comment newComment = commentService.addComment(comment);
        if (newComment != null){
            return new ResponseEntity<>(new CommentDTO(newComment), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/comment")
    public ResponseEntity<CommentDTO>  updateComment(@RequestBody Comment comment){
        CommentDTO updatedComment = commentService.updateComment(comment);
        if(updatedComment != null){
            return new ResponseEntity<>(updatedComment, HttpStatus.OK) ;
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }


}
