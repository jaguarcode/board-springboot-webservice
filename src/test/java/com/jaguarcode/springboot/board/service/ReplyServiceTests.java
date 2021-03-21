package com.jaguarcode.springboot.board.service;

import com.jaguarcode.springboot.board.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testGetList() {
        Long bno = 55L;
        List<ReplyDTO> replyDTOList = replyService.getList(bno);
        replyDTOList.forEach(System.out::println);
    }
}
