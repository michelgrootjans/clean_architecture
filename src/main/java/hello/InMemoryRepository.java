package hello;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryRepository implements AccountRepository {
    private Map<Integer, Account> accounts = new HashMap<>();

    public InMemoryRepository() {
        createAccount("Michel", 10);
        createAccount("Domenique", 20);
    }

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

    private void createAccount(String name, int credits) {
        Account account = buildAccount(name, credits);
        accounts.put(account.getId(),account);
    }
    private Account buildAccount(String owner, int credits) {
        Account account = new Account();
        int nextId = getNextId();
        account.setId(nextId);
        account.setOwner(owner);
        Transaction transaction = new Transaction();
        transaction.setCredits(credits);
        transaction.setDescription("some consumption");
        account.getTransactions().add(transaction);
        return account;
    }

    private int getNextId() {
        return accounts.values()
                .stream()
                .map(Account::getId)
                .reduce(0, Math::max)
                + 1;
    }
}
