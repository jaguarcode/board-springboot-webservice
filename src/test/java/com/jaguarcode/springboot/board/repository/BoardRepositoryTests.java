package com.jaguarcode.springboot.board.repository;

import com.jaguarcode.springboot.board.entity.Board;
import com.jaguarcode.springboot.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@google.com")
                    .build();
            Board board = Board.builder()
                    .title("Title" + i)
                    .content("Content" + i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        });
    }
}
