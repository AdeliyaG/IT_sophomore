package ru.itis.simpleblog.simple_blog.controller;

import org.springframework.web.bind.annotation.*;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;
import ru.itis.simpleblog.simple_blog.service.UserService;

@RestController
@RequestMapping("blog")
public class BlogController {

    private final UserService userService;

    public BlogController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    private String signUp(@RequestBody UserEntity user) {
        if (userService.signUp(user)) {
            return user.getUsername() + " has successfully registered!";
        } else {
            return "User with this username is already exist";
        }
    }

    @PostMapping("/signIn")
    private String signIn(@RequestBody UserEntity user) {
        String token = null;
        if ((token = userService.signIn(user)) != null) {
            return "Your token is: " + token;
        } else {
            return "Incorrect data";
        }
    }
}
