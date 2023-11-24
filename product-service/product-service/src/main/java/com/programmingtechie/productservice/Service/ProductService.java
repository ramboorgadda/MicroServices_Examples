package com.programmingtechie.productservice.Service;

import com.programmingtechie.productservice.Model.Product;
import com.programmingtechie.productservice.Repository.ProductRepository;
import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest ProductRequest){
        Product product= Product.builder()
                .name(ProductRequest.getName())
                .description(ProductRequest.getDescription())
                .price(ProductRequest.getPrice()).build();


        productRepository.save(product);
        log.info("Product {} is Saved",product.getId());
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
