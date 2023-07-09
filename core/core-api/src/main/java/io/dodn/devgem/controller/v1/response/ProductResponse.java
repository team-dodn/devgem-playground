package io.dodn.devgem.controller.v1.response;

public record ProductResponse(
        Long id, String name, String description, Long categoryId, String categoryName) {}
