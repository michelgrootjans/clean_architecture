package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private AccountAdministrationService service;

    public AdminController(AccountAdministrationService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("accounts", service.getAccounts());
        return "admin/index";
    }


}
