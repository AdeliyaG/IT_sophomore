package ru.itis.simpleblog.simple_blog.controller;

import org.springframework.web.bind.annotation.*;
import ru.itis.simpleblog.simple_blog.entity.CommentEntity;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;
import ru.itis.simpleblog.simple_blog.service.CommentService;

@RestController
@RequestMapping("blog")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post={post}/comment")
    public PostEntity addComment(@PathVariable Long post, @RequestBody CommentEntity comment, @RequestHeader String token) {
        return commentService.addComment(post, comment, token); // возвращает пост, на котором оставили коммент (но почему-то без нововго коммента)
    }
}
