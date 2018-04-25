package hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

@Service
public class InMemoryRepository implements AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    public InMemoryRepository() {
        accounts.add(buildAccount("Michel", 10));
        accounts.add(buildAccount("Domenique", 20));
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public Account getAccount(Long id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst().get();
    }

    @Override
    public void create(Account account) {
        account.setId(getNextId());
        accounts.add(account);
    }

    private Account buildAccount(String owner, int credits) {
        Account account = new Account();
        int nextId = getNextId();
        account.setId(nextId);
        account.setOwner(owner);
        account.setCredits(credits);
        return account;
    }

    private int getNextId() {
        return accounts.stream()
                .map(Account::getId)
                .reduce(0, Math::max)
                + 1;
    }
}
