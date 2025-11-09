package com.linkedIn.linkedIn_clone.repository;



import com.linkedIn.linkedIn_clone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostIdOrderByCreatedAtDesc(Long postId);
    int countByPostId(Long postId);
}
