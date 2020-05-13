package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.CommentDto;
import ru.itis.semestrwork.trello.service.CommentService;

@RestController
@RequestMapping("/api/trello")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/item={item_id}/comment")
    public ResponseEntity<?> addComment(@PathVariable Long item_id, @RequestBody CommentDto comment) {
        return ResponseEntity.ok(commentService.addComment(item_id, comment));
    }

}
