package pl.nullpointerexception.hexagonal.infrastructure.persistence.inmemory.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;

@Configuration
@Profile("mem")
public class ProductInMemoryConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort() {
        return new ProductInMemoryAdapter();
    }
}
