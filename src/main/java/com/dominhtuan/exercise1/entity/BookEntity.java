package com.dominhtuan.exercise1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
public class BookEntity extends BaseEntity {
    @Column
    private String name;
    @Column(name = "pagecount")
    private int pageCount;
    @Column
    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorid", nullable = false)
    private AuthorEntity authorEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookcategory",
            joinColumns = @JoinColumn(name = "bookid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "categoryid", nullable = false))
    private List<CategoryEntity> categoryEntities = new ArrayList<>();
}
