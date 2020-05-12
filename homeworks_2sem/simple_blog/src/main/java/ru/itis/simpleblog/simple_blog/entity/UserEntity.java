package ru.itis.simpleblog.simple_blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity extends AutoIncrement{

    private String username;
    private String password;

    @OneToMany(mappedBy = "userLike")
    private List<LikeEntity> like;

//    @ManyToMany(mappedBy = "likes")
//    private Integer like;

//    private List<PostEntity> post;

//    @ManyToMany
//    @JoinTable(name = "user_liked_post_rel",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "post_id"))
//    private List<PostEntity> likes = new ArrayList<>();
}
