package com.example.backEndProject.service;

import com.example.backEndProject.model.Post;
import com.example.backEndProject.model.Reply;
import com.example.backEndProject.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReplyService {
    private ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public Reply save(Reply reply) {

        return replyRepository.save(reply);
    }
    }

