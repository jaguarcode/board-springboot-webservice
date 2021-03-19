package com.jaguarcode.springboot.board.repository;

import com.jaguarcode.springboot.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
