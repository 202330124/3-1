package chapter05.controller;

import chapter05.member.MemberService;
import chapter05.member.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        System.out.println("MemberController 생성됨");
        this.memberService = memberService;
    }

    @GetMapping("/signUp")
    // @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup() {
        return "sign_up";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "sign_in";
    }

    @RequestMapping("/signUpConfirm")
    public String signUpConfirm(MemberVo memberVo) {
        System.out.println("id: " + memberVo.getId());
        System.out.println("name: " + memberVo.getName());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("password: " + memberVo.getPassword());

        memberService.signUpConfirm(memberVo);

        return "sign_up_ok";
    }
}