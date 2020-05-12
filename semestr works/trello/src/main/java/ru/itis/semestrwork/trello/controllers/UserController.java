package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.SignInDto;
import ru.itis.semestrwork.trello.dto.SignUpDto;
import ru.itis.semestrwork.trello.dto.TokenDto;
import ru.itis.semestrwork.trello.service.UserService;

@RestController
@RequestMapping("/api/trello")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    private ResponseEntity<?> signUp(@RequestBody SignUpDto userData) {
        userService.signUp(userData);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/signIn")
    private ResponseEntity<?> signIn(@RequestBody SignInDto userData) {
        TokenDto resp = userService.signIn(userData);
        return ResponseEntity.ok(resp);
    }

    //todo authWithSmth
}
