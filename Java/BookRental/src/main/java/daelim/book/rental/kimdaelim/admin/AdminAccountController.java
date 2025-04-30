package daelim.book.rental.kimdaelim.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {
    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        return "/admin/account/create_account_form";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/admin/account/login_form";
    }
}