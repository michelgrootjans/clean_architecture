package cashless.services;

import cashless.domain.Account;
import org.springframework.stereotype.Service;
import cashless.repositories.AccountRepository;

import java.util.Collection;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Account> getAccounts() {
        return repository.getAccounts();
    }

    @Override
    public Account getAccount(Long id) {
        return repository.getAccount(id);
    }

    @Override
    public void save(Account account) {
        if (account.getCredits() < 0) {
            throw new RuntimeException("Insufficient credits");
        }
        repository.save(account);
    }
}
