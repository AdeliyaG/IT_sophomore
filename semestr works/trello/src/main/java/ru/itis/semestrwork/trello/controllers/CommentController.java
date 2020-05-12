package ru.itis.semestrwork.trello.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.semestrwork.trello.service.CommentService;

@RestController
@RequestMapping("/api/trello")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


}
