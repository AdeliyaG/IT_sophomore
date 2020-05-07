package ru.itis.semestrwork.trello.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Moscow")
    private LocalDateTime deadline;

//    @OneToMany
//    private List<MultipartFile> media;     //todo
//    private List<String> checkList;     //todo

    @OneToMany
    private List<User> participants;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments;

    @ManyToOne
    @JsonIgnore
    private Card cardID;

    @ManyToOne
    @JsonIgnore
    private Archive archive;

    @Enumerated(value = EnumType.STRING)
    private ItemStatus itemStatus;
}
