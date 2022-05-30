package com.example.backEndProject.repository;

import com.example.backEndProject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Long> {


    @Query(value = "SELECT * FROM comments WHERE id = ?",nativeQuery = true)
    Comment findCommentByID(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO comments (post_id,commenter_userid,comment_content) " +
            "VALUES (?1 , ?2, ?3)",nativeQuery = true)
    void addComment(Long PostId, Long userId,String commentContent);


}
