package pl.nullpointerexception.hexagonal.infrastructure.application.rest.product.dto;

import org.hibernate.validator.constraints.Length;

public record ProductDto(
        @Length(min=4) String name,
        @Length(min=4) String description) {
}
