package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/admin/accounts/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("account", service.getAccount(id));
        return "admin/accounts/show";
    }



}
