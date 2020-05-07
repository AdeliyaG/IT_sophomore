package ru.itis.semestrwork.trello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrwork.trello.entity.Item;
import ru.itis.semestrwork.trello.entity.ItemStatus;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long item_id);

    List<Item> findItemsByArchiveIdAndItemStatus(Long archive_id, ItemStatus itemStatus);
}
