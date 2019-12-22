package com.whistle.needhi.controller;

import com.whistle.needhi.exception.ResourceNotFoundException;
import com.whistle.needhi.model.Comment;
import com.whistle.needhi.repository.CommentRepository;
import com.whistle.needhi.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @GetMapping("v1/complaints/{complaintId}/comments")
    public Page<Comment> getAllCommentsByComplaintId(@PathVariable(value = "complaintId") Long complaintId,
            Pageable pageable) {
        return commentRepository.findByComplaintId(complaintId, pageable);
    }

    @PostMapping("v1/complaints/{complaintId}/comments")
    public Comment createComment(@PathVariable(value = "complaintId") Long complaintId,
            @Valid @RequestBody Comment comment) {
        return complaintRepository.findById(complaintId).map(complaint -> {
            comment.setComplaint(complaint);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Complaint Id " + complaintId + " not found"));
    }

    @PutMapping("v1/complaints/{complaintId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "complaintId") Long complaintId,
            @PathVariable(value = "commentId") Long commentId, @Valid @RequestBody Comment commentRequest) {
        if (!complaintRepository.existsById(complaintId)) {
            throw new ResourceNotFoundException("complaintId " + complaintId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("v1/complaints/{complaintId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "complaintId") Long complaintId,
            @PathVariable(value = "commentId") Long commentId) {
        return commentRepository.findByIdAndComplaintId(commentId, complaintId)
                                .map(comment -> {
                                    commentRepository.delete(comment);
                                    return ResponseEntity.ok().build();
                                })
                                .orElseThrow(() -> new ResourceNotFoundException(
                                        "Comment not found with id " + commentId + " and complaintId " + complaintId));
    }
}