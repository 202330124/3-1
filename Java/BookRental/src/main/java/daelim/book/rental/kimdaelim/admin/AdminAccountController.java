package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}