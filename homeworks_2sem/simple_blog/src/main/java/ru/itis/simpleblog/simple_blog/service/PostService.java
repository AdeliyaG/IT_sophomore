package ru.itis.simpleblog.simple_blog.service;

import org.springframework.stereotype.Service;
import ru.itis.simpleblog.simple_blog.entity.LikeEntity;
import ru.itis.simpleblog.simple_blog.entity.PostEntity;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;
import ru.itis.simpleblog.simple_blog.repository.LikeRepository;
import ru.itis.simpleblog.simple_blog.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final TokenService tokenService;

    private final LikeRepository likeRepository;

    public PostService(PostRepository postRepository, TokenService tokenService, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.tokenService = tokenService;
        this.likeRepository = likeRepository;
    }

    public List<PostEntity> getPosts() {
        return postRepository.findAll();
    }

    public List<PostEntity> getPostsByUserId(Long userId) {
        return postRepository.findAllByUser_Id(userId);
    }

    public List<PostEntity> getPostByPostId(Long postId) {
        return postRepository.findAllById(postId);
    }

    public List<PostEntity> getPostByPostIdAndAuthUser(Long post, String token) { //todo
        UserEntity auth = tokenService.checkToken(token);
        Long userId = auth.getId();
        PostEntity postEntity = postRepository.findById(post).get();

        if (!likeRepository.isUserLikedPost(auth, postEntity).isEmpty()) {
            postEntity.setUserLiked(true);
            return postRepository.findAllById(post);
        } else {
            postEntity.setUserLiked(false);
            return postRepository.findAllById(post);
        }
    }


    public UserEntity create(PostEntity post, String token) {
        UserEntity auth = tokenService.checkToken(token);
        if (auth != null) {
            post.setUser(auth);
            postRepository.save(post);
            post.setCountOfLikes(0);
            return auth;
        } else {
            return null;
        }
    }

    public PostEntity update(Long id, PostEntity post, String token) {
        UserEntity auth = tokenService.checkToken(token);
        PostEntity postEntity = postRepository.getOne(id);
        if (auth != null && auth.getId().equals(postEntity.getUser().getId())) {
            postEntity.setTitle(post.getTitle());
            postEntity.setBody(post.getBody());
            return postRepository.save(postEntity);
        } else {
            return null;
        }
    }

    public List<PostEntity> delete(Long id, String token) {
        UserEntity auth = tokenService.checkToken(token);
        PostEntity postEntity = postRepository.getOne(id);
        if (auth != null && auth.getId().equals(postEntity.getUser().getId())) {
            postRepository.deleteById(id);
            return getPosts();
        } else {
            return null;
        }
    }

    public PostEntity like(Long post, String token) {
        UserEntity auth = tokenService.checkToken(token);
        PostEntity postEntity = postRepository.findById(post).get();
        LikeEntity likeEntity = new LikeEntity();
        if (auth != null) {
            postEntity.setUserLiked(true);

            likeEntity.setUserLike(auth);
            likeEntity.setPostLiked(postEntity);
            likeRepository.save(likeEntity);
            postEntity.setCountOfLikes(postEntity.getCountOfLikes()+1);
            return postEntity;
        } else {
            return null;
        }
    }

    public PostEntity unlike(Long post, String token) {
        UserEntity auth = tokenService.checkToken(token);
        PostEntity postEntity = postRepository.findById(post).get();
        if (auth != null) {
            postEntity.setUserLiked(false);

            likeRepository.deleteByPostLikedId(post);
            postEntity.setCountOfLikes(postEntity.getCountOfLikes()-1);
            return postEntity;
        } else {
            return null;
        }
    }
}
