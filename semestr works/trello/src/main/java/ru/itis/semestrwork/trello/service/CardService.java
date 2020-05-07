package ru.itis.semestrwork.trello.service;

import org.springframework.stereotype.Service;
import ru.itis.semestrwork.trello.dto.CardDto;
import ru.itis.semestrwork.trello.entity.Board;
import ru.itis.semestrwork.trello.entity.Card;
import ru.itis.semestrwork.trello.repository.BoardRepository;
import ru.itis.semestrwork.trello.repository.CardRepository;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final BoardRepository boardRepository;

    public CardService(CardRepository cardRepository, BoardRepository boardRepository) {
        this.cardRepository = cardRepository;
        this.boardRepository = boardRepository;
    }

    public List<Card> createCard(CardDto cardDto, Long board_id) {
        Board board = boardRepository.findBoardById(board_id);

        Card card = Card.builder()
                .title(cardDto.getTitle())
                .boardID(board)
                .build();

        cardRepository.save(card);
        return boardRepository.findBoardById(board_id).getCards();
    }
}
