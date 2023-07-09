package io.dodn.devgem.storage.db.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ProductEntity extends BaseEntity {

    @Column private String name;

    @Column private String description;

    @Column private Long categoryId;

    public ProductEntity() {}

    public ProductEntity(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
