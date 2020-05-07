package ru.itis.semestrwork.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrwork.trello.dto.BoardDto;
import ru.itis.semestrwork.trello.entity.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardById(Long boardID);
}
