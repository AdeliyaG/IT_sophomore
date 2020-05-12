package ru.itis.simpleblog.simple_blog.controller;

import org.springframework.web.bind.annotation.*;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;
import ru.itis.simpleblog.simple_blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("blog")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostEntity> getPosts(@RequestParam(defaultValue = "") Long user, @RequestParam(defaultValue = "") Long post) { // ?user=id_юзера || post=id_поста
        if (user != null) {
            return postService.getPostsByUserId(user); // вывести все посты определенного юзера
        } else if (post != null) {
            return postService.getPostByPostId(post); // вывести определенный пост
        } else {
            return postService.getPosts(); // вывести все существующие посты
        }
    }

    @GetMapping("/auth")
    public List<PostEntity> getPostsWithLike(@RequestParam Long post, @RequestHeader String token) { // ?post=id_поста
        return postService.getPostByPostIdAndAuthUser(post, token); // вывести определенный пост с лайком
    }

    @PostMapping("/create")
    private List<PostEntity> createPost(@RequestBody PostEntity post, @RequestHeader String token) {
        return postService.getPostsByUserId(postService.create(post, token).getId()); // создает пост и после выводит все посты пользователя
    }

    @PutMapping("/edit")
    private PostEntity updatePost(@RequestParam Long post, @RequestBody PostEntity postEntity, @RequestHeader String token) { // /edit?post=id_поста
        return postService.update(post, postEntity, token); // выводит отредактированный пост
    }

    @DeleteMapping("/delete")
    private List<PostEntity> deletePost(@RequestParam Long post, @RequestHeader String token) { // /delete?post=id_поста
        return postService.delete(post, token); // возвращает все посты
    }

    @PostMapping("")
    public PostEntity likePost(@RequestParam Long post, @RequestParam Boolean like, @RequestHeader String token) {
        //?post=id&like=true
        if (post != null && like) {
            return postService.like(post, token);
        } else {
            return postService.unlike(post, token);
        }
    }
}
