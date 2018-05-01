package cashless.repositories;

import cashless.domain.Account;

import java.util.Collection;

public interface AccountRepository {
    Collection<Account> getAccounts();

    Account getAccount(Long id);

    void save(Account account);
}
