package com.example.backEndProject.repository;

import com.example.backEndProject.AbstractContainerBaseTest;
import com.example.backEndProject.model.Comment;
import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void addCommentTest(){

        //given - setup or precondition

        User user = new User("test","test",
                "test","test","test");
        Post post = new Post("test",user);



        //when - action or the testing

        commentRepository.addComment(post.getId(),user.getId(),"testme");

        Comment savedComment = commentRepository.findCommentByID(1L);


        //then - verify output

        Assertions.assertNotNull(savedComment);
        Assertions.assertEquals("testme",savedComment.getCommentContent());


    }

    @Test
    public void findCommentByIDTest(){

        //given
        User user = new User("test","test",
                "test","test","test");
        Post post = new Post("test",user);


        //when

        commentRepository.addComment(post.getId(),user.getId(),"testme");

        //then

        Comment savedComment = commentRepository.findCommentByID(2L);
        Assertions.assertNotNull(savedComment.getId());



    }





}
