package ru.itis.semestrwork.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne
    private Archive archive;

    @ManyToMany //?is that ok? todo
    private List<User> participants;

    @OneToMany(mappedBy = "boardID")
    private List<Card> cards;

}
