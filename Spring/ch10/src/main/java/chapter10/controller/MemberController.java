package chapter10.controller;

import chapter10.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/members")
    public String members(Model model, @ModelAttribute("cmd") ListCommand listCommand, Errors errors) {
        if(errors.hasErrors()) {
            return "member/memberList";
        }

        System.out.println("From: " + listCommand.getFrom());
        System.out.println("To: " + listCommand.getTo());

        if(listCommand.getFrom() != null && listCommand.getTo() != null) {
            System.out.println("From: " + listCommand.getFrom());
            System.out.println("To: " + listCommand.getTo());
            List<Member> members = memberService.selectByRegDate(listCommand);
            System.out.println("members: " + members.size());

            List<MemberRes> resList = members.stream().map(MemberRes::new).collect(Collectors.toList());
            model.addAttribute("members", resList);
        }

        return "member/memberList";
    }

    @GetMapping("/members/{id}")
    public String membersDetail(@PathVariable Long id, Model model) {
        Member member = memberService.selectById(id);

        if(true) {
            throw new RuntimeException();
        }

        if(member == null) {
            // model.addAttribute("cmd", new ListCommand());
            // return "member/memberList";

            throw new MemberNotFoundException();
        }

        model.addAttribute("member", new MemberRes(member));

        return "member/memberDetail";
    }

    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "member/invalidId";
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public String handleNotFoundException() {
        return "member/noMember";
    }
}