package hello;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountAdministrationServiceImpl implements AccountAdministrationService {
    private AccountRepository repository;

    public AccountAdministrationServiceImpl(AccountRepository repository) {
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
        repository.save(account);
    }
}
