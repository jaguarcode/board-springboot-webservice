package com.jaguarcode.springboot.board.service;

import com.jaguarcode.springboot.board.dto.BoardDTO;
import com.jaguarcode.springboot.board.dto.PageRequestDTO;
import com.jaguarcode.springboot.board.dto.PageResultDTO;
import com.jaguarcode.springboot.board.entity.Board;
import com.jaguarcode.springboot.board.entity.Member;
import com.jaguarcode.springboot.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto) {
        log.info(this.getClass().getSimpleName() + "::register");
        Board board = dtoToEntity(dto);
        boardRepository.save(board);
        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(this.getClass().getSimpleName() + "::getList");
        Function<Object[], BoardDTO> fn
                = (en -> entityToDto((Board) en[0], (Member) en[1], (Long)en[2]));
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno) {
        Object result = boardRepository.getBoardByBno(bno);
        Object[] arr = (Object[]) result;
        return entityToDto((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }
}
