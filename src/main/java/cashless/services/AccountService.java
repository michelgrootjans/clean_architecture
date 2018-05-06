package cashless.services;

import cashless.domain.Account;

import java.util.Collection;

public interface AccountService {
    Collection<Account> getAccounts();

    Account getAccount(Long id);

    void save(Account account);

    void deliver(Account account);
}
