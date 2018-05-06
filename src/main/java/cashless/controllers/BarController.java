package cashless.controllers;

import cashless.domain.Account;
import cashless.domain.Product;
import cashless.services.AccountService;
import cashless.services.ProductService;
import cashless.vo.AccountMapper;
import cashless.vo.AccountVO;
import cashless.vo.AccountVOMapper;
import cashless.vo.ProductVOMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class BarController {
    private AccountService accountService;

    public BarController(AccountService service) {
        this.accountService = service;
    }

    @GetMapping("/bar")
    public String index(Model model) {
        Collection<AccountVO> accounts = accountService.getAccounts()
                .stream()
                .map(AccountVOMapper::map)
                .collect(Collectors.toList());
        model.addAttribute("accounts", accounts);
        return "bar/index";
    }

    @GetMapping("/bar/{id}")
    public String show(@PathVariable Long id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", AccountVOMapper.map(account));

        return "bar/show";
    }

    @PostMapping(value = "/bar")
    public String update(@ModelAttribute AccountVO accountVO) {
        try {
            accountService.deliver(AccountMapper.map(accountVO, null));
        } catch (Exception e) {
            // meh... just swallow
        }
        return "redirect:/bar/" + accountVO.getId();
    }
}
