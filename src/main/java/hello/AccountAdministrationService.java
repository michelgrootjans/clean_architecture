package hello;

import java.util.List;

public interface AccountAdministrationService {
    List<Account> getAccounts();

    Account getAccount(Long id);

    void create(Account account);
}
