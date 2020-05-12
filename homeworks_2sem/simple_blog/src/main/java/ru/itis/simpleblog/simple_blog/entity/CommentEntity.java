package ru.itis.simpleblog.simple_blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity extends AutoIncrement {
    private String body;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    @JsonIgnore
    private PostEntity post;
}
