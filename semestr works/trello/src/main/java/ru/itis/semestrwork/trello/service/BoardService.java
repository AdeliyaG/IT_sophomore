package ru.itis.semestrwork.trello.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrwork.trello.dto.BoardDto;
import ru.itis.semestrwork.trello.dto.UserDto;
import ru.itis.semestrwork.trello.entity.*;
import ru.itis.semestrwork.trello.repository.ArchiveRepository;
import ru.itis.semestrwork.trello.repository.BoardRepository;
import ru.itis.semestrwork.trello.repository.ItemRepository;
import ru.itis.semestrwork.trello.repository.UserRepository;
import ru.itis.semestrwork.trello.security.UserDetailsImpl;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final ArchiveRepository archiveRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, ArchiveRepository archiveRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.archiveRepository = archiveRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public List<Board> getListOfBoards(Long user_id) {
        return userRepository.findUserById(user_id).getBoards();
    }

    public Board getBoard(Long board_id) {
        return boardRepository.findBoardById(board_id);
    }

    public List<User> getParticipants(Long board_id) {
        return boardRepository.findBoardById(board_id).getParticipants();
    }

    public Archive getBoardArchive(Long board_id) {
        return boardRepository.findBoardById(board_id).getArchive();
    }

    public List<Item> getBoardArchiveItems(Long board_id) {
        Archive archive = boardRepository.findBoardById(board_id).getArchive();
        return itemRepository.findItemsByArchiveIdAndItemStatus(archive.getId(), ItemStatus.ARCHIVED);
    }

    @Transactional
    public Board createBoard(BoardDto boardDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserById(userDetails.getUserId());

        List<User> userList = new ArrayList<>();
        userList.add(user);

        Board board = Board.builder()
                .name(boardDto.getName())
                .archive(createArchive())
                .participants(userList)
                .build();
        boardRepository.save(board);
        board.getArchive().setBoard(board);
        boardRepository.save(board);
        return board;
    }

    private Archive createArchive() {
        Archive archive = Archive
                .builder()
                .build();
        archiveRepository.save(archive);
        return archive;
    }

    @Transactional
    public void addParticipants(UserDto username, Long board_id) throws AccessDeniedException {
        User user = userRepository.findUserByUsername(username.getUsername());

        if (user != null) {
            Board board = boardRepository.findBoardById(board_id);
            List<User> userList = board.getParticipants();
            userList.add(user);
            board.setParticipants(userList);
            boardRepository.save(board);
        } else throw new AccessDeniedException("User is not found");

    }

    @Transactional
    public void deleteParticipants(UserDto username, Long board_id) throws AccessDeniedException {
        User user = userRepository.findUserByUsername(username.getUsername());

        if (user != null) {
            Board board = boardRepository.findBoardById(board_id);
            board.getParticipants().remove(user);
            boardRepository.save(board);
        } else throw new AccessDeniedException("User is not found");
    }

    @Transactional
    public void deleteBoard(Long board_id) throws AccessDeniedException {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserById(userDetails.getUserId());
        Board board = boardRepository.findBoardById(board_id);

        if (board.getParticipants().contains(user)) {
            board.getCards().removeAll(board.getCards());
            board.getParticipants().removeAll(board.getParticipants());
            boardRepository.deleteById(board_id);
        } else throw new AccessDeniedException("Unavailable operation");
    }
}
