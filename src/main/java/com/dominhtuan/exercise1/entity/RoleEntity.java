package com.dominhtuan.exercise1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends BaseEntity {
    @Column
    private String code;
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roleEntities")
    private List<UserEntity> userEntities = new ArrayList<>();
}
