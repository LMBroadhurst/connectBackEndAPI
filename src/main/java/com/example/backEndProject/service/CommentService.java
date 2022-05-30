package com.example.backEndProject.service;

import com.example.backEndProject.LoginCheckMethod.LoginChecker;
import com.example.backEndProject.model.Comment;
import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.CommentRepository;
import com.example.backEndProject.repository.PostRepository;
import com.example.backEndProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {


//    DEPENDENCY INJECTIONS


    private UserRepository userRepository;
    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private LoginChecker loginChecker;


//    END OF DEPENDENCY INJECTIONS
//
//
//    CONSTRUCTORS


    public CommentService(UserRepository userRepository, PostRepository postRepository,
                          CommentRepository commentRepository, LoginChecker loginChecker) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.loginChecker = loginChecker;
    }

    public Map<String,String> showAllComments(){


        Map<String,String> result = new HashMap<>();
        List<Post> posts = commentRepository.findAll().stream().map(comment -> comment.getPost()).toList();
        List<Comment> comments = commentRepository.findAll();

        if(comments.isEmpty()){
            result.put("No comments to show","try posting a comment");
            return result;
        }

        for(int i = 0; i < posts.size(); i++){

            Post currentPostInForLoop = posts.get(i);
            List<Comment> commentsCorrespondingToCurrentPost = comments.stream().filter(comment -> comment
                    .getPost().getId() == currentPostInForLoop.getId()).toList();

            List<String> commentContent = commentsCorrespondingToCurrentPost.stream().map(comment -> comment.getCommentContent()).toList();

            result.put("POST: " + currentPostInForLoop.getContent_text() + " || POSTED BY: " + currentPostInForLoop.getUser().getName()
                    + " || LIKES: " + currentPostInForLoop.getNumber_of_likes(),"COMMENTS(S): "
                    + commentContent);
        }

        return result;
    }


    public String findCommentByID(Long id){

        try{
            Comment resultComment =  commentRepository.findCommentByID(id);


            return "COMMENT ID: " + resultComment.getId()
                    + " || COMMENT CONTENT: " + resultComment.getCommentContent()
                    + " || LIKES: " + resultComment.getLikes()
                    + " || POST: " + resultComment.getPost().getContent_text();
        }catch(NullPointerException e){

            return "This comment does not exist, input a valid comment ID";
        }



    }

    public String heartComment(String user_name, Long commentId){



        try{


            if(this.loginChecker.userNotLoggedInChecker(user_name)){
                return this.loginChecker.returnedMessage();
            }



            User result_user = userRepository.findUserByName(user_name);
            Comment result_comment = commentRepository.findCommentByID(commentId);

            if(result_user.getId()==
                    result_comment.getPost().getUser().getId()){

                result_comment.setHeartByUser(Boolean.TRUE);
                commentRepository.save(result_comment);
                return "Comment \"" + result_comment.getCommentContent() + "\" hearted by " + result_user.getName();

            }



        }catch(NullPointerException e){
            if(userRepository.findUserByName(user_name)==null
                    && commentRepository.findCommentByID(commentId) != null){
                return "You may not heart this comment as: User does not exist";
            } else if (commentRepository.findCommentByID(commentId)==null
                    && userRepository.findUserByName(user_name)!=null) {
                return "You may not heart this comment as: Comment does not exist";
            } else if(userRepository.findUserByName(user_name)==null
                    && commentRepository.findCommentByID(commentId) == null){
                return "You may not heart this comment as: User and comment do not exist";
            }
        }

           return "You may not heart this comment as: You didn't create this post";

    }


    public String addComment(

                             Long post_id,
                             String username,
                             String commentContent){



        try{


            if(this.loginChecker.userNotLoggedInChecker(username)){
                return this.loginChecker.returnedMessage();
            }



        }catch(NullPointerException e){

            if(userRepository.findUserByName(username)==null && postRepository.findPostByID(post_id)!=null){
                return "You may not post this comment as: User does not exist";
            } else if (postRepository.findPostByID(post_id)==null && userRepository.findUserByName(username)!=null) {
                return "You may not post this comment as: Post does not exist";
            } else if(userRepository.findUserByName(username)==null && postRepository.findPostByID(post_id)==null){
                return "You may not post this comment as: User and post do not exist";
            }


        }

        commentRepository.addComment(post_id,userRepository.findUserByName(username).getId(),commentContent);


        return "Comment \"" + commentContent +  "\" posted by " + userRepository.findUserByName(username).getName() +
                " on " + postRepository.findPostByID(post_id).getUser().getName() + "'s post";


    }

    public void deleteCommentById(Long id){
        commentRepository.deleteById(id);
    }


    public void changeCommentContent(String commentContent,Long id){

        Comment resultComment = commentRepository.findCommentByID(id);

        resultComment.setCommentContent(commentContent);

        commentRepository.save(resultComment);
    }


//    END OF METHODS
//
//
//    END OF FILE
}
