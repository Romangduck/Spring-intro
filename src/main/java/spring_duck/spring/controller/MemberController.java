package spring_duck.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring_duck.spring.domain.Member;
import spring_duck.spring.service.MemberService;

import java.util.List;


@Controller
public class MemberController {

     private final MemberService memberService;

     @Autowired
    public  MemberController(MemberService memberService) {
         this.memberService = memberService;
     }
    //의존관계 주입

    @GetMapping("/members/new")
    public String createForm(){
         return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
