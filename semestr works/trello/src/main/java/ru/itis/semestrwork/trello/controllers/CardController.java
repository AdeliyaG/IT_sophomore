package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.CardDto;
import ru.itis.semestrwork.trello.service.CardService;

@RestController
@RequestMapping("/api/trello")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

//    @GetMapping
//    public ResponseEntity<?> getListOfItems() {
//        return ResponseEntity.ok(itemService.createItem(itemCreateDto, card_id));
//    }

    @PostMapping("/board={board_id}/addCard")
    private ResponseEntity<?> createCard(@PathVariable Long board_id, @RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardService.createCard(cardDto, board_id));
    }

//
//    @DeleteMapping("/card={card_id}/delete")
//    public ResponseEntity<?> deleteCard(@PathVariable Long card_id) {
//        cardService.deleteCard(card_id);
//        return ResponseEntity.ok("Card " + card_id + " deleted");
//    }

    //todo renameCard, deleteCard (insane)
}
