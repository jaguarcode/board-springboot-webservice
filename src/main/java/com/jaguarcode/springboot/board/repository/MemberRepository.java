package com.jaguarcode.springboot.board.repository;

import com.jaguarcode.springboot.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
