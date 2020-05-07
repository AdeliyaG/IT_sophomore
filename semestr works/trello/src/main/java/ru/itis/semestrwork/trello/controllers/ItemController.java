package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.ItemDto;
import ru.itis.semestrwork.trello.dto.UserDto;
import ru.itis.semestrwork.trello.service.ItemService;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/trello")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/card={card_id}")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemCreateDto, @PathVariable Long card_id) {
        return ResponseEntity.ok(itemService.createItem(itemCreateDto.getTitle(), card_id));
    }

    @PutMapping("/item={item_id}/descr")
    public ResponseEntity<?> setDescription(@RequestBody ItemDto description, @PathVariable Long item_id) {
        itemService.addDescription(description.getDescription(), item_id);
        return ResponseEntity.ok("Description is set");
    }

    @PutMapping("/item={item_id}/d")
    public ResponseEntity<?> setDeadline(@RequestBody ItemDto date, @PathVariable Long item_id) {
        itemService.addDeadline(date.getDeadline(), item_id);
        return ResponseEntity.ok("Deadline is set");
    }

    @PutMapping("/item={item_id}/p")
    public ResponseEntity<?> addItemParticipants(@RequestBody UserDto username, @PathVariable Long item_id) throws AccessDeniedException {
        itemService.addItemParticipants(username, item_id);
        return ResponseEntity.ok("User added to card");
    }

    @DeleteMapping("/item={item_id}/pd")
    public ResponseEntity<?> deleteItemParticipants(@RequestBody UserDto username, @PathVariable Long item_id) throws AccessDeniedException {
        itemService.deleteItemParticipants(username, item_id);
        return ResponseEntity.ok("User deleted from card");
    }

    @PutMapping("/item={item_id}/archive")                  //todo подумать как выводить в карточке только открытые итемы
    public ResponseEntity<?> archiveItem(@PathVariable Long item_id) {
        itemService.archiveItem(item_id);
        return ResponseEntity.ok("Archived");
    }

    // todo addFile
}
