package spring_duck.spring.repository;

import spring_duck.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 - 저장
    Optional<Member> findById(Long id); // 회원 - ID 조회
    Optional<Member> findByName(String name); // 회원 - Name 조회
    List<Member> findAll(); // 회원 - 전체 조회
}
