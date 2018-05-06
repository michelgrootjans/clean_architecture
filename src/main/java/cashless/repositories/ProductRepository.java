package cashless.repositories;

import cashless.domain.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> getProducts();

    void save(Product product);

    Product findProduct(int productId);
}
