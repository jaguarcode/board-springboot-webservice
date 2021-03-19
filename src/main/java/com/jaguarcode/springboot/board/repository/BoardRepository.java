package com.jaguarcode.springboot.board.repository;

import com.jaguarcode.springboot.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
