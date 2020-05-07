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
@Table(name = "archive")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JsonIgnore
    private Board board;

    @OneToMany(mappedBy = "archive")
    @JsonIgnore
    private List<Item> items;

}
