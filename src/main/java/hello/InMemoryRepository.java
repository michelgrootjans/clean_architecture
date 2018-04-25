package hello;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InMemoryRepository implements AccountRepository {
    private List<Account> accounts = Arrays.asList(new Account(1, "Michel"), new Account(2, "Domenique"));

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }
}
