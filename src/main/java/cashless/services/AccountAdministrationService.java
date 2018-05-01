package cashless.services;

import cashless.domain.Account;

import java.util.Collection;

public interface AccountAdministrationService {
    Collection<Account> getAccounts();

    Account getAccount(Long id);

    void save(Account account);
}
