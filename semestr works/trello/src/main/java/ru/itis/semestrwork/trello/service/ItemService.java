package ru.itis.semestrwork.trello.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrwork.trello.dto.UserDto;
import ru.itis.semestrwork.trello.entity.*;
import ru.itis.semestrwork.trello.repository.CardRepository;
import ru.itis.semestrwork.trello.repository.ItemRepository;
import ru.itis.semestrwork.trello.repository.UserRepository;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public ItemService(ItemRepository itemRepository, CardRepository cardRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    public Item createItem(String title, Long card_id) {
        Item item = Item.builder()
                .title(title)
                .itemStatus(ItemStatus.OPENED)
                .cardID(cardRepository.findCardById(card_id))
                .archive(cardRepository.findCardById(card_id).getBoardID().getArchive())
                .deadline(null)
                .description(null)
                .build();
        itemRepository.save(item);
        return item;
    }

    public void addDescription(String descr, Long item_id) {
        Item item = itemRepository.findItemById(item_id);
        item.setDescription(descr);
        itemRepository.save(item);
    }

    public void addDeadline(LocalDateTime data, Long item_id) {
        Item item = itemRepository.findItemById(item_id);
        item.setDeadline(data);
        itemRepository.save(item);
    }

    public void addItemParticipants(UserDto username, Long item_id) throws AccessDeniedException {
        User user = userRepository.findUserByUsername(username.getUsername());

        if (user != null) {
            Item item = itemRepository.findItemById(item_id);
            List<User> userList = item.getParticipants();
            userList.add(user);
            item.setParticipants(userList);
            itemRepository.save(item);
        } else throw new AccessDeniedException("User is not found");

    }

    public void deleteItemParticipants(UserDto username, Long item_id) throws AccessDeniedException {
        User user = userRepository.findUserByUsername(username.getUsername());

        if (user != null) {
            Item item = itemRepository.findItemById(item_id);
            item.getParticipants().remove(user);
            itemRepository.save(item);
        } else throw new AccessDeniedException("User is not found");
    }

    public void archiveItem(Long item_id) {
        Item item = itemRepository.findItemById(item_id);
        item.setItemStatus(ItemStatus.ARCHIVED);
        itemRepository.save(item);
    }

    public void unarchiveItem(Long item_id) {
        Item item = itemRepository.findItemById(item_id);
        item.setItemStatus(ItemStatus.OPENED);
        itemRepository.save(item);
    }

}
