package hello;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAdministrationServiceImpl implements AccountAdministrationService {
    private AccountRepository repository;

    public AccountAdministrationServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> getAccounts() {
        return repository.getAccounts();
    }
}