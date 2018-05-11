package cashless.controllers;

import cashless.domain.Account;
import cashless.domain.Product;
import cashless.services.AccountService;
import cashless.services.ProductService;
import cashless.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class CustomerController {
    private AccountService accountService;
    private ProductService productService;

    public CustomerController(AccountService service, ProductService productService) {
        this.accountService = service;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Collection<AccountVO> accounts = accountService.getAccounts()
                .stream()
                .map(AccountVOMapper::map)
                .collect(Collectors.toList());
        model.addAttribute("accounts", accounts);

        return "customers/welcome";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", AccountVOMapper.map(account));

        Collection<Product> products = productService.getProducts();
        model.addAttribute("products", ProductVOMapper.map(products));

        return "customers/show";
    }

    @PostMapping(value = "/")
    public String update(@ModelAttribute AccountVO accountVO) {
        try {
            accountService.save(AccountMapper.map(accountVO, productService));
        } catch (Exception e) {
            // meh... just swallow
        }
        return "redirect:" + accountVO.getId();
    }
}
