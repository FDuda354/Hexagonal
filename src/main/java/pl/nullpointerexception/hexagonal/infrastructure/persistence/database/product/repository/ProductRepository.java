package pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nullpointerexception.hexagonal.infrastructure.persistence.database.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
