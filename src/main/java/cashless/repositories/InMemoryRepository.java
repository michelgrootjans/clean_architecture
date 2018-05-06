package cashless.repositories;

import cashless.domain.Account;
import cashless.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryRepository implements AccountRepository, ProductRepository {
    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<Integer, Product> products = new HashMap<>();
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


    @Override
    public Collection<Product> getProducts() {
        return products.values();
    }

    @Override
    public void save(Product product) {
        if(product.getId() == 0)
            product.setId(getNextId());
        products.put(product.getId(), product);
    }

    @Override
    public Product findProduct(int productId) {
        return products.get(productId);
    }
}
