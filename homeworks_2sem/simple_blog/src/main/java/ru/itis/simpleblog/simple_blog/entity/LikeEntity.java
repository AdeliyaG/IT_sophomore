package ru.itis.simpleblog.simple_blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_liked_post_rel")
public class LikeEntity extends AutoIncrement{ // todo rel between userID and postID

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userLike;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private PostEntity postLiked;
}
