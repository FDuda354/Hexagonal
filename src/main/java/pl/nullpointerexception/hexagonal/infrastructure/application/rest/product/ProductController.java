package pl.nullpointerexception.hexagonal.infrastructure.application.rest.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.hexagonal.domain.product.model.Product;
import pl.nullpointerexception.hexagonal.domain.product.port.in.ProductServicePort;
import pl.nullpointerexception.hexagonal.infrastructure.application.rest.product.dto.ProductDto;

import java.util.List;

@RestController
public class ProductController {

    private static final Long EMPTY_ID = null;
    private ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productServicePort.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDto productDto) {
        return productServicePort.addProduct(new Product(EMPTY_ID, productDto.name(), productDto.description()));
    }

}
