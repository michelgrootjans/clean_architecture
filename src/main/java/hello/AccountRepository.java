package hello;

import java.util.List;

public interface AccountRepository {
    List<Account> getAccounts();

    Account getAccount(Long id);
}
