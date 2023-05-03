package pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.nullpointerexception.hexagonal.domain.product.port.out.ProductRepositoryPort;
import pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product.repository.ProductRepository;

@Configuration
@Profile("!mem")
public class ProductDatabaseConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort(ProductRepository productRepository) {
        return new ProductDatabaseAdapter(productRepository);
    }
}
