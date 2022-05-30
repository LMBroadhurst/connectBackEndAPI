package com.example.backEndProject.method;

import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.User;
import com.example.backEndProject.repository.PostRepository;
import com.example.backEndProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class FileWriter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public FileWriter(UserRepository userRepository, PostRepository postRepository) throws IOException {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Post fileWriter(Long id,
                         String new_content)
            throws NoSuchElementException, IOException {
        Post current = null;
        try {
            current = postRepository.findById(id).get();
            current.setContent_text(new_content);
            postRepository.save(current);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No matching post could be found for id: " + id);
        }

        File myFile = new File("src/all_posts_and_post_edits.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        java.io.FileWriter fileWriter = new java.io.FileWriter(myFile, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(current.getContent_text());
        printWriter.println(LocalDateTime.now());
        printWriter.println(current.getUser().getName());
        printWriter.println("");
        printWriter.close();
        return current;
    }

    public Post addPostWriter(
            Long id,
            String content_text,
            Integer number_of_likes,
            boolean isBusinessAccount,
            Integer post_type_id,
            Long user_id) throws IOException {


        Post post = new Post(id, content_text, number_of_likes, isBusinessAccount, post_type_id);
        postRepository.save(post);

        File myFile = new File("src/all_posts_and_post_edits.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User postUser = userRepository.findByID(user_id);
        java.io.FileWriter fileWriter = new java.io.FileWriter(myFile, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(post.getContent_text());
        printWriter.println(LocalDateTime.now());
        printWriter.println(postUser.getName());
        printWriter.println("");

        printWriter.close();

        return postRepository.save(post);
    }
}
