package io.dodn.devgem.controller.v1.response;

import io.dodn.devgem.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record ProductListResponse(Set<ProductCategoryGroupResponse> products) {
    public ProductListResponse(List<Product> products) {
        this(
                products.stream()
                        .collect(Collectors.groupingBy(product -> product.category().id()))
                        .entrySet()
                        .stream()
                        .map(
                                entry ->
                                        new ProductCategoryGroupResponse(
                                                entry.getKey(), getCollect(entry)))
                        .collect(Collectors.toSet()));
    }

    private static Set<ProductResponse> getCollect(Map.Entry<Long, List<Product>> entry) {
        return entry.getValue().stream()
                .map(
                        each ->
                                new ProductResponse(
                                        each.id(),
                                        each.name(),
                                        each.description(),
                                        each.category().id(),
                                        each.category().name()))
                .collect(Collectors.toSet());
    }
}
