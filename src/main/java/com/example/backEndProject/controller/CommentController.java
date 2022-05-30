package com.example.backEndProject.controller;

import com.example.backEndProject.model.Comment;
import com.example.backEndProject.model.Post;
import com.example.backEndProject.service.CommentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

//    INJECTION MAPPING START

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }


//    INJECTION MAPPING END
//
//
//    GET MAPPING START


    @GetMapping("showAllComments")
    public Map<String,String> showAllComments(){



        return commentService.showAllComments();

    }




    @GetMapping("findCommentById/{id}")
    public String findCommentByID(@PathVariable("id") Long id){

        return commentService.findCommentByID(id);

    }


//    GET MAPPING END
//
//
//    PUT MAPPING START


    @PutMapping("heartComment")
    public String heartComment(
                               @RequestParam("userName") String user_name,
                               @RequestParam("ID_of_comment_to_be_hearted") Long Id_of_comment_to_be_hearted
                               ){

        return commentService.heartComment(user_name,Id_of_comment_to_be_hearted);




    }

    @PutMapping("changeCommentContent")
    public String changeCommentContent(@RequestParam("change_comment_content_to") String change_comment_content_to,
            @RequestParam("comment_id") Long id){

        try{
            commentService.changeCommentContent(change_comment_content_to,id);
        }catch(NullPointerException e){

            return "This comment does not exist";
        }

        return "Comment successfully updated";

    }

//    PUT MAPPING END
//
//
//    POST MAPPING START


    @PostMapping("postComment")
    public String postComment(@RequestParam("postID") Long post_id,
                             @RequestParam("username") String username,
                             @RequestParam("content") String commentContent){



        return commentService.addComment(post_id,username,commentContent);
    }


//    POST MAPPING END
//
//
//    DELETE MAPPING START


    @DeleteMapping("deleteCommentById/{id}")
    public String deleteCommentById(@PathVariable("id") Long id){

        try{
            commentService.deleteCommentById(id);
        }catch(EmptyResultDataAccessException e){
            return "This comment doesn't exist";
        }


        return "Comment Deleted";
    }


//    DELETE MAPPING END
//
//
//    END OF FILE


}
