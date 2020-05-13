package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.FacebookDto;
import ru.itis.semestrwork.trello.dto.SignInDto;
import ru.itis.semestrwork.trello.dto.SignUpDto;
import ru.itis.semestrwork.trello.dto.TokenDto;
import ru.itis.semestrwork.trello.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/trello")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    private ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto userData) {
        userService.signUp(userData);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/signIn")
    private ResponseEntity<?> signIn(@Valid @RequestBody SignInDto userData) {
        TokenDto resp = userService.signIn(userData);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/signInWithFacebook")
    private ResponseEntity<?> signInWithFacebook(@RequestBody FacebookDto user) {
        TokenDto resp = userService.signInWithFacebook(user);
        return ResponseEntity.ok(resp);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
