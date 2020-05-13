package ru.itis.semestrwork.trello.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;

    @JsonIgnore
    private String hashPassword;

    @ManyToMany
    @JoinTable(name = "user_board_rel",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "board_id") })
    @JsonIgnore
    private List<Board> boards;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
