package com.example.backEndProject.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void showAllComments_WorksThroughAllLayers() throws Exception {


        Map<String, String> result = new HashMap<>();
        result.put("No comments to show", "try posting a comment");

        MvcResult mvcResult = this.mockMvc.perform(get("/showAllComments"))
                .andExpect(status().isOk())
                // some extra logging
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        // map JSON to java
        Map<String, String> mapFromJSON = objectMapper.readValue(contentAsString, new TypeReference<HashMap<String, String>>() {
        });

        assertNotNull(mapFromJSON.get("No comments to show"));

    }

    @Test
    void findCommentByID_WorksThroughAllLayers() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/findCommentById/{id}", "1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        Assertions.assertEquals("This comment does not exist, input a valid comment ID"
                , mvcResult.getResponse().getContentAsString());

    }
}

//    @Test
//    void heartComment() throws Exception {
//
//        MvcResult mvcResult = this.mockMvc.perform(get("/heartComment?userName=Jem&ID_of_comment_to_be_hearted=1"))
//                .andExpect(status().isOk())
//                // some extra logging
//                .andDo(print())
//                .andReturn();
//
//        Assertions.assertEquals("You may not heart this comment as: You didn't create this post"
//                ,mvcResult.getResponse().getContentAsString());
//
//    }
//
//    @Test
//    void changeCommentContent() {
//    }
//
//    @Test
//    void postComment() throws Exception {
//
//        MvcResult mvcResult = this.mockMvc.perform(get("/postComment?postID=1&username=noname&content=I love pizza so much"))
//                .andExpect(status().isOk())
//                // some extra logging
//                .andDo(print())
//                .andReturn();
//
//        Assertions.assertEquals("You may not post this comment as: User does not exist"
//                ,mvcResult.getResponse().getContentAsString());
//
//
//
//    }
//
//    @Test
//    void deleteCommentById() {
//    }
//}