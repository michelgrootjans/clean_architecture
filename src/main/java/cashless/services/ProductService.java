package cashless.services;

import cashless.domain.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> getProducts();

    Product findProduct(int productId);
}
