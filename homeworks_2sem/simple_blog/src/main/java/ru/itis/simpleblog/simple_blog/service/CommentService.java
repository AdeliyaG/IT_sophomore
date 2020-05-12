package ru.itis.simpleblog.simple_blog.service;

import org.springframework.stereotype.Service;
import ru.itis.simpleblog.simple_blog.entity.CommentEntity;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;
import ru.itis.simpleblog.simple_blog.repository.CommentRepository;
import ru.itis.simpleblog.simple_blog.repository.PostRepository;

import javax.transaction.Transactional;


@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TokenService tokenService;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, TokenService tokenService, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.tokenService = tokenService;
        this.postRepository = postRepository;
    }

    @Transactional
    public PostEntity addComment(Long post, CommentEntity comment, String token) {
        UserEntity auth = tokenService.checkToken(token);
        PostEntity postEntity = postRepository.findById(post).get();
        if (auth != null) {
            comment.setUser(auth);
            comment.setPost(postEntity);
            commentRepository.save(comment);
            return postRepository.findById(post).get();
        } else {
            return null;
        }
    }
}
