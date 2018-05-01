package cashless.repositories;

import cashless.domain.Account;
import cashless.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RepositorySeeder {
    public RepositorySeeder(AccountRepository repository) {
        repository.save(buildAccount("Michel", 10));
        repository.save(buildAccount("Domenique", 20));

    }

    private Account buildAccount(String owner, int credits) {
        Account account = new Account();
        account.setOwner(owner);
        Transaction transaction = new Transaction();
        transaction.setCredits(credits);
        transaction.setDescription("some consumption");
        account.getTransactions().add(transaction);
        return account;
    }

}
