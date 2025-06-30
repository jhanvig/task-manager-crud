package com.example.basic.demo.service;

import com.example.basic.demo.model.Board;
import com.example.basic.demo.model.User;
import com.example.basic.demo.repository.BoardRepository;
import com.example.basic.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board createBoard(Board board) {
        // Save users first to ensure they get IDs
        List<User> persistedUsers = board.getMembers().stream()
            .map(userRepository::save)
            .toList();

        board.setMembers(persistedUsers); // Link the persisted users
        return boardRepository.save(board); // Save board after linking
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
