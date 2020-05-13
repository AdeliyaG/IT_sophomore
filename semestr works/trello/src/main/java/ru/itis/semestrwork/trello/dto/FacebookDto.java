package ru.itis.semestrwork.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FacebookDto {
    private String username;
    private String email;
    private String password;
}
