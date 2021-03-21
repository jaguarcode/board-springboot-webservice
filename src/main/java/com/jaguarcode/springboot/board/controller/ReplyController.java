package com.jaguarcode.springboot.board.controller;

import com.jaguarcode.springboot.board.dto.ReplyDTO;
import com.jaguarcode.springboot.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno) {
        log.info(this.getClass().getSimpleName() + "::getListByBoard");
        return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> register(@RequestBody ReplyDTO replyDTO) {
        log.info(this.getClass().getSimpleName() + "::register");
        log.info(replyDTO);
        replyService.register(replyDTO);
        ResponseEntity responseEntity = new ResponseEntity<>("success", HttpStatus.OK);
        log.info(responseEntity);
        return responseEntity;
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        log.info(this.getClass().getSimpleName() + "::register");
        log.info("RNO:" + rno );
        replyService.remove(rno);
        ResponseEntity responseEntity = new ResponseEntity<>("success", HttpStatus.OK);
        log.info(responseEntity);
        return responseEntity;
    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {
        log.info(this.getClass().getSimpleName() + "::modify");
        log.info(replyDTO);
        replyService.modify(replyDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
