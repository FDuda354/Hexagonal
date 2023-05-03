package pl.nullpointerexception.hexagonal.domain.product.port.out;

import pl.nullpointerexception.hexagonal.domain.product.model.Product;

import java.util.List;

public interface ProductRepositoryPort {

    List<Product> findAll();

    Product save(Product product);
}
