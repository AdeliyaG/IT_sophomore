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
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Archive archive;

    @ManyToMany
    @JoinTable(name = "user_board_rel",
            joinColumns = { @JoinColumn(name = "board_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    @JsonIgnore
    private List<User> participants;

    @OneToMany(mappedBy = "boardID")
    private List<Card> cards;

}
