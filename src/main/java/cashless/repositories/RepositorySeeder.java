package cashless.repositories;

import cashless.domain.Account;
import cashless.domain.Product;
import cashless.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RepositorySeeder {
    public RepositorySeeder(AccountRepository accountRepository, ProductRepository productRepository) {
        accountRepository.save(buildAccount("Michel", 10));
        accountRepository.save(buildAccount("Domenique", 20));

        productRepository.save(buildProduct("Beer", 2));
        productRepository.save(buildProduct("Coke Light", 1));
        productRepository.save(buildProduct("Fanta", 1));
    }

    private Product buildProduct(String name, int credits) {
        Product product = new Product();
        product.setName(name);
        product.setCredits(credits);
        return product;
    }

    private Account buildAccount(String owner, int credits) {
        Account account = new Account();
        account.setOwner(owner);
        Transaction transaction = new Transaction();
        transaction.setCredits(credits);
        transaction.setDescription("initial credits");
        account.getTransactions().add(transaction);
        return account;
    }

}
