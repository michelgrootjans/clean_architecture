package cashless.services;

import cashless.domain.Product;
import cashless.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Product> getProducts() {
        return repository.getProducts();
    }

    @Override
    public Product findProduct(int productId) {
        return repository.findProduct(productId);
    }
}
