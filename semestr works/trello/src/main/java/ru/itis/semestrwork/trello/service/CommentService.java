package ru.itis.semestrwork.trello.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.semestrwork.trello.dto.CommentDto;
import ru.itis.semestrwork.trello.entity.Card;
import ru.itis.semestrwork.trello.entity.Comment;
import ru.itis.semestrwork.trello.entity.Item;
import ru.itis.semestrwork.trello.entity.User;
import ru.itis.semestrwork.trello.repository.CommentRepository;
import ru.itis.semestrwork.trello.repository.ItemRepository;
import ru.itis.semestrwork.trello.repository.UserRepository;
import ru.itis.semestrwork.trello.security.UserDetailsImpl;

import javax.transaction.Transactional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Comment addComment(Long item_id, CommentDto commentDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserById(userDetails.getUserId());

        Item item = itemRepository.findItemById(item_id);
        Comment comment = Comment.builder()
                .body(commentDto.getBody())
                .item(item)
                .user(user)
                .build();
        commentRepository.save(comment);
        return comment;
    }
}
