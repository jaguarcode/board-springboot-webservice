package com.jaguarcode.springboot.board.service;

import com.jaguarcode.springboot.board.dto.BoardDTO;
import com.jaguarcode.springboot.board.dto.PageRequestDTO;
import com.jaguarcode.springboot.board.dto.PageResultDTO;
import com.jaguarcode.springboot.board.entity.Board;
import com.jaguarcode.springboot.board.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);

    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();
        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
    }

    default BoardDTO entityToDto(Board board, Member member, Long replyCount) {
        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegdate())
                .modDate(board.getModdate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();
    }
}
