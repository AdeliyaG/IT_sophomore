package ru.itis.simpleblog.simple_blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity extends AutoIncrement{
    private String title;
    private String body;

    private Boolean userLiked;
    private Integer countOfLikes;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER) //todo lazy for pagination
    private List<CommentEntity> comment;

    @OneToMany(mappedBy = "postLiked")
    private List<LikeEntity> like;

//    @ManyToMany
//    @JoinTable(name = "user_liked_post_rel",
//            joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<PostEntity> likes = new ArrayList<>();
}
