package com.example.basic.demo.controller;

import com.example.basic.demo.model.Board;
import com.example.basic.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // Get all boards
    @GetMapping("all")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    // Get a board by ID
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        Optional<Board> board = boardService.getBoardById(id);
        return board.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new board
    @PostMapping("make")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    // Delete a board by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
