package com.dominhtuan.exercise1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class AuthorEntity extends BaseEntity{
    @Column
    private String name;
    @Column(name = "surname")
    private String surName;

    @OneToMany(mappedBy = "authorEntity",fetch = FetchType.LAZY)
    private List<BookEntity> bookEntities = new ArrayList<>();
}
