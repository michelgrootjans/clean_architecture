package hello;

import java.util.Collection;

public interface AccountAdministrationService {
    Collection<Account> getAccounts();

    Account getAccount(Long id);

    void save(Account account);
}
