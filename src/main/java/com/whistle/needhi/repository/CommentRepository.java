package com.whistle.needhi.repository;

import com.whistle.needhi.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByComplaintId(Long complaintId, Pageable pageable);
    Optional<Comment> findByIdAndComplaintId(Long id, Long postId);
}