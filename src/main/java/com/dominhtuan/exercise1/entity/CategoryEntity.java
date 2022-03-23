package com.dominhtuan.exercise1.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity {
    @Column
    private String code;
    @Column
    private String name;

    @ManyToMany(mappedBy = "categoryEntities",fetch = FetchType.LAZY)
    private List<BookEntity> bookEntities = new ArrayList<>();
}
