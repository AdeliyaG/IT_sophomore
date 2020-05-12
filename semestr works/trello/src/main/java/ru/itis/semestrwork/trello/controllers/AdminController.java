package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.semestrwork.trello.service.UserService;

@RestController
@RequestMapping("/api/trello")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    private ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
