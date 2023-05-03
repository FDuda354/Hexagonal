package pl.nullpointerexception.hexagonal.domain.product.port.in;

import pl.nullpointerexception.hexagonal.domain.product.model.Product;

import java.util.List;

public interface ProductServicePort {

    List<Product> getProducts();

    Product addProduct(Product product);
}
