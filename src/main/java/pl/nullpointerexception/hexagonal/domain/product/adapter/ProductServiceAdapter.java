package pl.nullpointerexception.hexagonal.domain.product.adapter;

import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.in.ProductServicePort;
import pl.nullpointerexception.hexagonal.domain.product.service.ProductService;

import java.util.List;

public class ProductServiceAdapter implements ProductServicePort {

    private final ProductService productService;

    public ProductServiceAdapter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }
}
