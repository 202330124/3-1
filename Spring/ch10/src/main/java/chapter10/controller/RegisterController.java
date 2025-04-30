package chapter10.controller;

import chapter10.DuplicationMemberException;
import chapter10.MemberRegisterService;
import chapter10.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    private final MemberRegisterService memberRegisterService;

    public RegisterController(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping("/register/step1")
    public String handleStep1() {
        System.out.println("handleStep1 >>>");
        return "register/step1";
    }

    /*
    @PostMapping("/register/step2")
    public String handleStep2(HttpServletRequest request) {
        System.out.println("handleStep2 >>>");

        String agree = request.getParameter("agree");
        System.out.println("agree: " + agree);

        if(agree == null || !agree.equals("true")) {
            return "register/step1";
        }

        return "register/step2";
    }
    */

    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        System.out.println("handleStep2 >>>");
        System.out.println("agree: " + agree);

        if(!agree) {
            return "register/step1";
        }

        model.addAttribute("registerRequest", new RegisterRequest());

        return "register/step2";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@ModelAttribute("registerRequest") RegisterRequest registerRequest) {
        System.out.println("handleStep3 >>>");
        System.out.println("email: " + registerRequest.getEmail());
        System.out.println("name: " + registerRequest.getName());
        System.out.println("password: " + registerRequest.getPassword());
        System.out.println("confirmPassword: " + registerRequest.getConfirmPassword());

        try {
            memberRegisterService.registerMember(registerRequest);
            return "register/step3";
        } catch(DuplicationMemberException ex) {
            return "register/step2";
        }
    }
}