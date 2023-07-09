package io.dodn.devgem.domain;

import io.dodn.devgem.support.SearchRange;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductReader productReader;

    public ProductService(ProductReader productReader) {
        this.productReader = productReader;
    }

    public List<Product> findProducts(SearchRange range) {
        return productReader.read(range);
    }
}
