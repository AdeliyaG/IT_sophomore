package ru.itis.semestrwork.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    @NotBlank(message = "Поле username не может быть пустым")
    @Size(min = 1, max = 20, message = "Username должен содержать от 1 до 20 символов")
    private String username;

    @NotBlank(message = "Поле email не может быть пустым")
    @Email(message = "Некорректный email")
    private String email;

    @NotBlank(message = "Поле password не может быть пустым")
    @Size(min = 8, message = "Пароль должен содержать не менее 8 символов")
    private String password;
}

