package cashless.controllers;

import cashless.domain.Account;
import cashless.repositories.AccountRepository;
import cashless.vo.AccountMapper;
import cashless.vo.AccountVO;
import cashless.vo.AccountVOMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CashierController {
    private AccountRepository accountService;

    public CashierController(AccountRepository accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/cashier")
    public String index(@RequestParam(required = false, name = "accountId") Long accountId, Model model) {
        if(accountId == null)
            return "cashier/index";

        Account account = accountService.getAccount(accountId);
        model.addAttribute("account", AccountVOMapper.map(account));
        return "cashier/show";
    }

    @PostMapping(value = "/cashier")
    public String update(@ModelAttribute AccountVO accountVO) {
        try {
            accountService.save(AccountMapper.map(accountVO, null));
        } catch (Exception e) {
            // meh... just swallow
        }
        return "redirect:/cashier";
    }

}
