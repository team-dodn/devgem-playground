package io.dodn.devgem.storage.db.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CategoryEntity extends BaseEntity {

    @Column private String name;

    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
