package ru.itis.semestrwork.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrwork.trello.dto.BoardDto;
import ru.itis.semestrwork.trello.dto.UserDto;
import ru.itis.semestrwork.trello.entity.Board;
import ru.itis.semestrwork.trello.security.UserDetailsImpl;
import ru.itis.semestrwork.trello.service.BoardService;

@RestController
@RequestMapping("/api/trello")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    private ResponseEntity<?> getBoards() {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(boardService.getListOfBoards(user.getUserId()));
    }

    @GetMapping("/board")
    private ResponseEntity<?> getBoard(@RequestParam Long b) {
        return ResponseEntity.ok(boardService.getBoard(b));
    }

    @GetMapping("/boardParticipants")
    private ResponseEntity<?> getParticipants(@RequestParam Long b) {
        return ResponseEntity.ok(boardService.getParticipants(b));
    }


    @GetMapping("/boardArchive")
    private ResponseEntity<?> getBoardArchive(@RequestParam Long b) {
        return ResponseEntity.ok(boardService.getBoardArchiveItems(b));
    }


    @PostMapping("/createBoard")
    private ResponseEntity<Board> createBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }

    @PutMapping("/board={board_id}/p")
    public ResponseEntity<?> addParticipants(@RequestBody UserDto username, @PathVariable Long board_id) throws AccessDeniedException, java.nio.file.AccessDeniedException {
        boardService.addParticipants(username, board_id);
        return ResponseEntity.ok("User added to board");
    }

    @DeleteMapping("/board={board_id}/pd")
    public ResponseEntity<?> deleteParticipants(@RequestBody UserDto username, @PathVariable Long board_id) throws java.nio.file.AccessDeniedException {
        boardService.deleteParticipants(username, board_id);
        return ResponseEntity.ok("User deleted from card");
    }

    @DeleteMapping("/board={board_id}/delete")
    public ResponseEntity<?> deleteBoard(@PathVariable Long board_id) throws java.nio.file.AccessDeniedException {
        boardService.deleteBoard(board_id);
        return ResponseEntity.ok("Board " + board_id + " deleted");
    }

    //todo probably добавить renameTable
}
