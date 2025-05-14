package chapter10.controller;

import chapter10.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String login(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) {
        if(rememberCookie != null) {
            loginCommand.setEmail(rememberCookie.getValue());
            loginCommand.setRememberEmail(true);
        }

        return "login/loginForm";
    }

    @PostMapping("/login")
    public String loginSubmit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);

        if(errors.hasErrors()) {
            return "login/loginForm";
        }

        try {
            // login 관련 서비스 연동
            AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
            session.setAttribute("authInfo", authInfo);

            // rememberEmail 처리
            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
            rememberCookie.setPath("/");

            if(loginCommand.isRememberEmail()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 30);
            } else {
                rememberCookie.setMaxAge(0);
            }

            response.addCookie(rememberCookie);

            return "login/loginSuccess";
        } catch(MemberNotFoundException e) {
            errors.reject("MemberNotFound");

            return "login/loginForm";
        } catch(WrongPasswordException we) {
            errors.reject("WrongPassword");

            return "login/loginForm";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/main";
    }
}