package pl.nullpointerexception.hexagonal.infrastructure.application.rest.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.domain.product.adapter.ProductServiceAdapter;
import pl.nullpointerexception.hexagonal.domain.product.port.in.ProductServicePort;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;
import pl.nullpointerexception.hexagonal.domain.product.service.ProductService;

@Configuration
public class ProductConfig {

    @Bean
    public ProductServicePort productServicePort(ProductRepositoryPort productRepositoryPort,
                                                 EmailNotificationPort emailNotificationPort) {
        return new ProductServiceAdapter(new ProductService(productRepositoryPort, emailNotificationPort));
    }
}
