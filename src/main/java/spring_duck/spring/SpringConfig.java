package spring_duck.spring;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_duck.spring.aop.TimeTraceAop;
import spring_duck.spring.controller.MemberController;
import spring_duck.spring.repository.*;
import spring_duck.spring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}

