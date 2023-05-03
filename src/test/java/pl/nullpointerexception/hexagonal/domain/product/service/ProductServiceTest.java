package pl.nullpointerexception.hexagonal.domain.product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private static final Long EMPTY_ID = null;
    @Mock
    private EmailNotificationPort emailNotificationPort;
    @Mock
    private ProductRepositoryPort productRepositoryPort;
    @InjectMocks
    private ProductService productService;

    @Test
    void shouldAddProduct() {
        // given
        Product product = new Product(EMPTY_ID, "Product 1", "Opis 1");
        when(productRepositoryPort.save(any(Product.class))).then(invocation -> {
            product.setId(1L);
            return product;
        });
        // when
        Product result = productService.addProduct(product);
        // then
        then(productRepositoryPort).should().save(product);
        verify(productRepositoryPort).save(product);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Product 1");
        assertThat(result.getDescription()).isEqualTo("Opis 1");
    }
}