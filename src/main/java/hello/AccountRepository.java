package hello;

import java.util.Collection;

public interface AccountRepository {
    Collection<Account> getAccounts();

    Account getAccount(Long id);

    void save(Account account);
}
