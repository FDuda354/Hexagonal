package pl.nullpointerexception.hexagonal.domain.product.adapter;

import org.junit.jupiter.api.Test;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;
import pl.nullpointerexception.hexagonal.domain.product.service.ProductService;
import pl.nullpointerexception.hexagonal.infrastructure.notification.inmemory.email.EmailNotificationAdapter;
import pl.nullpointerexception.hexagonal.infrastructure.persistence.inmemory.product.ProductInMemoryAdapter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceAdapterTest {

    private ProductRepositoryPort productRepositoryPort = new ProductInMemoryAdapter();
    private EmailNotificationPort emailNotificationPort = new EmailNotificationAdapter();
    private ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(new ProductService(productRepositoryPort,
            emailNotificationPort));

    @Test
    void shouldAddProduct() {
        // given
        Product product = new Product(null, "Product 1", "Opis 1");
        // when
        Product result = productServiceAdapter.addProduct(product);
        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo("Product 1");
        assertThat(result.getDescription()).isEqualTo("Opis 1");
    }

    @Test
    void shouldGetProducts() {
        // given
        productRepositoryPort.save(new Product(null, "Product 1", "Opis 1"));
        // when
        List<Product> result = productServiceAdapter.getProducts();
        // then
        assertThat(result).isNotEmpty();
    }
}