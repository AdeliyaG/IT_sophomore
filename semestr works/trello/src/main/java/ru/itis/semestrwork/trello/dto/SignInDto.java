package ru.itis.semestrwork.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInDto {

    @NotBlank(message = "Поле username не может быть пустым")
    private String username;

    @NotBlank(message = "Поле password не может быть пустым")
    private String password;
}
