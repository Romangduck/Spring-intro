package spring_duck.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_duck.spring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
