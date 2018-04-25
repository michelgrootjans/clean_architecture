package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/admin/accounts")
    public String create(@RequestParam("owner") String owner, @RequestParam("credits") int credits) {
        Account account = new Account();
        account.setOwner(owner);
        account.setCredits(credits);
        service.create(account);
        return "redirect:/admin";
    }



}
