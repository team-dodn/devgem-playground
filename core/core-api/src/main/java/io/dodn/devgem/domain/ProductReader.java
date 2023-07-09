package io.dodn.devgem.domain;

import io.dodn.devgem.storage.db.core.ProductEntity;
import io.dodn.devgem.storage.db.core.ProductRepository;
import io.dodn.devgem.support.SearchRange;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductReader {

    private final ProductRepository productRepository;

    private final CategoryReader categoryReader;

    public ProductReader(ProductRepository productRepository, CategoryReader categoryReader) {
        this.productRepository = productRepository;
        this.categoryReader = categoryReader;
    }

    public List<Product> read(SearchRange range) {
        Slice<ProductEntity> products =
                productRepository.findAllBy(PageRequest.of(range.page(), range.size()));
        Set<Long> categoryIds =
                products.map(ProductEntity::getCategoryId).stream().collect(Collectors.toSet());

        Map<Long, Category> categories = categoryReader.readMap(categoryIds);

        return products
                .map(
                        each ->
                                new Product(
                                        each.getId(),
                                        each.getName(),
                                        each.getDescription(),
                                        categories.get(each.getCategoryId())))
                .stream()
                .collect(Collectors.toList());
    }
}
