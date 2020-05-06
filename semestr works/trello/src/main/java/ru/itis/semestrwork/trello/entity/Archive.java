package ru.itis.semestrwork.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "archive")
@AllArgsConstructor
@NoArgsConstructor
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Board board;

    @OneToMany(mappedBy = "archive")
    private List<Item> items;

}
