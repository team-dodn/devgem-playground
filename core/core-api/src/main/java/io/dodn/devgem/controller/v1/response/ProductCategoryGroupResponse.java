package io.dodn.devgem.controller.v1.response;

import java.util.Set;

public record ProductCategoryGroupResponse(Long categoryId, Set<ProductResponse> products) {}
