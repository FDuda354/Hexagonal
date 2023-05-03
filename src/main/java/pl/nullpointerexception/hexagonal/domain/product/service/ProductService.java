package pl.nullpointerexception.hexagonal.domain.product.service;

import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;

import java.util.List;

public class ProductService {

    private final ProductRepositoryPort productRepositoryPort;
    private final EmailNotificationPort emailNotificationPort;

    public ProductService(ProductRepositoryPort productRepositoryPort, EmailNotificationPort emailNotificationPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.emailNotificationPort = emailNotificationPort;
    }

    public List<Product> getProducts() {
        return productRepositoryPort.findAll();
    }

    public Product addProduct(Product product) {
        Product result = productRepositoryPort.save(product);
        emailNotificationPort.send(List.of("admin@admin.pl"), "Product o id=" + result.getId() + " został dodany");
        return result;
    }
}
