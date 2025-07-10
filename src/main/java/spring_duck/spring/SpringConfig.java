package spring_duck.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_duck.spring.controller.MemberController;
import spring_duck.spring.repository.JdbcMemberRepository;
import spring_duck.spring.repository.JdbcTemplateMemberRepository;
import spring_duck.spring.repository.MemberRepository;
import spring_duck.spring.repository.MemoryMemberRepository;
import spring_duck.spring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository(); 메모리
// return new JdbcMemberRepository(dataSource); jdbc
        return new JdbcTemplateMemberRepository(dataSource);
    }
}

