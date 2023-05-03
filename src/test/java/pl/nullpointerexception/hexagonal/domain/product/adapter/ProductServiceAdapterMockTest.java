package pl.nullpointerexception.hexagonal.domain.product.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;
import pl.nullpointerexception.hexagonal.domain.product.service.ProductService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceAdapterMockTest {

    private ProductRepositoryPort productRepositoryPort = mock(ProductRepositoryPort.class);
    private EmailNotificationPort emailNotificationPort = mock(EmailNotificationPort.class);
    private ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(new ProductService(productRepositoryPort, emailNotificationPort));

    @Test
    void shouldAddProduct() {
        // given
        Product product = new Product(null, "Product 1", "Opis 1");
        when(productRepositoryPort.save(any())).then(invocation -> {
            product.setId(1L);
            return product;
        });
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
        when(productRepositoryPort.findAll()).thenAnswer(invocation -> List.of(new Product(null, "Product 1", "Opis 1")));
        productRepositoryPort.save(new Product(null, "Product 1", "Opis 1"));
        // when
        List<Product> result = productServiceAdapter.getProducts();
        // then
        assertThat(result).isNotEmpty();
    }
}