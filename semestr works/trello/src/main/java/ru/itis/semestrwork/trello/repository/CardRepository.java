package ru.itis.semestrwork.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrwork.trello.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findCardById(Long card_id);
}
