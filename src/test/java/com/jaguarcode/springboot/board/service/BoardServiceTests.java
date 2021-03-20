package com.jaguarcode.springboot.board.service;

import com.jaguarcode.springboot.board.dto.BoardDTO;
import com.jaguarcode.springboot.board.dto.PageRequestDTO;
import com.jaguarcode.springboot.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Test")
                .content("Test Contents")
                .writerEmail("user55@google.com") // email should be exist one.
                .build();
        Long bno = boardService.register(boardDTO);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
        for(BoardDTO boardDTO : result.getDtoList())
            System.out.println(boardDTO);
    }

    @Test
    public void testGet() {
        Long bno = 99L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }
}
