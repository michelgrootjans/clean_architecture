package cashless.repositories;

import cashless.domain.Transaction;
import cashless.domain.Account;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryRepository implements AccountRepository {
    private Map<Integer, Account> accounts = new HashMap<>();
    static int nextId = 1;

    @Override
    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    @Override
    public Account getAccount(Long id) {
        return accounts.values()
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public void save(Account account) {
        if(account.getId() == 0)
            account.setId(getNextId());
        accounts.put(account.getId(), account);
    }

    private int getNextId() {
        return nextId++;
    }


}
