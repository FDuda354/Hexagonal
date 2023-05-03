package pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product;

import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;
import pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product.entity.ProductEntity;
import pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product.repository.ProductRepository;

import java.util.List;

public class ProductDatabaseAdapter  implements ProductRepositoryPort {

    private ProductRepository productRepository;

    public ProductDatabaseAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(productEntity -> new Product(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getDescription()
                )).toList();
    }

    @Override
    public Product save(Product product) {
        ProductEntity result = productRepository.save(new ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription()
        ));
        return new Product(result.getId(), result.getName(), result.getDescription());
    }
}
