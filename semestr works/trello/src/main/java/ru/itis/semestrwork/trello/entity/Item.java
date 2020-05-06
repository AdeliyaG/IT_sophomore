package ru.itis.semestrwork.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime deadline;
//    private List<String> media;     //todo
//    private List<String> checkList;     //todo

    @OneToMany
    private List<User> itemParticipants;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments;

    @ManyToOne
    private Card cardID;

    @ManyToOne
    private Archive archive;

}
