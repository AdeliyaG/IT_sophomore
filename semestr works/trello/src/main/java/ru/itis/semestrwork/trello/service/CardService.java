package ru.itis.semestrwork.trello.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrwork.trello.dto.CardDto;
import ru.itis.semestrwork.trello.entity.Board;
import ru.itis.semestrwork.trello.entity.Card;
import ru.itis.semestrwork.trello.entity.User;
import ru.itis.semestrwork.trello.repository.BoardRepository;
import ru.itis.semestrwork.trello.repository.CardRepository;
import ru.itis.semestrwork.trello.repository.UserRepository;
import ru.itis.semestrwork.trello.security.UserDetailsImpl;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    public CardService(CardRepository cardRepository, BoardRepository boardRepository, UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<Card> createCard(CardDto cardDto, Long board_id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserById(userDetails.getUserId());

        Board board = boardRepository.findBoardById(board_id);

        if (board.getParticipants().contains(user)) {
            Card card = Card.builder()
                    .title(cardDto.getTitle())
                    .boardID(board)
                    .build();

            cardRepository.save(card);
            return boardRepository.findBoardById(board_id).getCards();
        } else throw new AccessDeniedException("Unavailable operation");
    }

//    @Transactional
//    public void deleteCard(Long card_id) throws AccessDeniedException {
//        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userRepository.findUserById(userDetails.getUserId());
//
//        Card card = cardRepository.findCardById(card_id);
//        Board board = boardRepository.findBoardById(card.getBoardID().getId());
//
//        if (board.getParticipants().contains(user)) {
//            card.getItems().removeAll(card.getItems());
//            cardRepository.deleteById(card_id);
//        } else throw new AccessDeniedException("Unavailable operation");
//    }

    //bruh why its so hard
}
