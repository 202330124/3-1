package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {
    @Autowired
    private AdminAccountService adminAccountService;

    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        return "/admin/account/create_account_form";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/admin/account/login_form";
    }

    @PostMapping("/createAccountConfirm")
    public String createAccountConfirm(AdminAccountVo adminAccountVo) {
        // TODO 회원가입 처리

        String nextPage = "/admin/account/create_account_ok";

        int result = adminAccountService.createAccount(adminAccountVo);
        if(result <= 0) nextPage = "/admin/account/create_account_ng";

        return nextPage;
    }

    @PostMapping("/loginConfirm")
    public String loginConfirm(AdminAccountVo adminAccountVo, HttpSession session, HttpServletResponse response) {
        String nextPage = "/admin/account/login_ok";

        // 로그인 처리하는 서비스 연동
        AdminAccountVo loginedAdminAccountVo = adminAccountService.login(adminAccountVo);
        if(loginedAdminAccountVo == null) {
            nextPage = "/admin/account/login_ng";
        }

        session.setAttribute("loginedAdminAccountVo", loginedAdminAccountVo);

        // Cookie cookie = new Cookie("loginAccount", loginedAdminAccountVo.getId());
        // cookie.setMaxAge(3600);
        // response.addCookie(cookie);

        return nextPage;
    }

    @GetMapping("/logoutConfirm")
    public String logoutConfirm(HttpSession session) {
        session.invalidate();

        return "/admin/home";
    }

    @GetMapping("/modifyAccountForm")
    public String modifyAccountForm(HttpSession session) {
        String nextPage = "/admin/account/modify_account_form";

        if(session.getAttribute("loginedAdminAccountVo") == null) {
            nextPage = "/admin/account/login_form";
        }

        return nextPage;
    }

    @PostMapping("/modifyAccountConfirm")
    public String modifyAccountConfirm(AdminAccountVo adminAccountVo, HttpSession session) {
        String nextPage = "/admin/account/modify_account_ok";

        int result = adminAccountService.modifyAccount(adminAccountVo);

        if(result > 0) {
            AdminAccountVo loginedAdminAccountVo = adminAccountService.getLoginedAdminAccountVo(adminAccountVo.getNo());
            session.setAttribute("loginedAdminAccountVo", loginedAdminAccountVo);
        } else {
            nextPage = "/admin/account/modify_account_ng";
        }

        return nextPage;
    }

    @GetMapping("/findPasswordForm")
    public String findPasswordForm() {
        return "/admin/account/find_password_form";
    }

    @PostMapping("/findPasswordConfirm")
    public String findPasswordConfirm(AdminAccountVo adminAccountVo) {
        String nextPage = "/admin/account/find_password_ok";

        // TODO service -> find password logic
        return nextPage;
    }
}