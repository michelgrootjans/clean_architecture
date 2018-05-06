package cashless.controllers;

import cashless.domain.Transaction;
import cashless.domain.Account;
import cashless.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cashless.services.AccountService;
import cashless.vo.AccountMapper;
import cashless.vo.AccountVO;
import cashless.vo.AccountVOMapper;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    private AccountService service;
    private ProductService productService;

    public AdminController(AccountService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        Collection<AccountVO> accounts = service.getAccounts()
                .stream()
                .map(AccountVOMapper::map)
                .collect(Collectors.toList());
        model.addAttribute("accounts", accounts);
        return "admin/index";
    }

    @GetMapping("/admin/accounts/{id}")
    public String show(@PathVariable Long id, Model model) {
        Account account = service.getAccount(id);
        AccountVO vo = AccountVOMapper.map(account);
        model.addAttribute("account", vo);
        return "admin/accounts/show";
    }

    @PostMapping("/admin/accounts")
    public String create(@RequestParam("owner") String owner, @RequestParam("credits") int credits) {
        Account account = new Account();
        account.setOwner(owner);
        Transaction transaction = new Transaction();
        transaction.setCredits(credits);
        account.getTransactions().add(transaction);
        service.save(account);
        return "redirect:/admin";
    }

    @PostMapping("/admin/accounts/{accountId}")
    public String update(@PathVariable   Long accountId, @ModelAttribute AccountVO accountVO) {
        service.save(AccountMapper.map(accountVO, productService));
        return "redirect:/admin/accounts/" + accountId;
    }



}
