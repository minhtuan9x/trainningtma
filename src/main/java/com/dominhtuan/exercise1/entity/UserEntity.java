package com.dominhtuan.exercise1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Column(name = "username",unique = true,nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String passWord;
    @Column(name = "fullname",nullable = false)
    private String fullName;
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userrole",
    joinColumns = @JoinColumn(name = "userid",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "roleid",nullable = false))
    private List<RoleEntity> roleEntities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "userEntities")
    private List<BookEntity> bookEntities = new ArrayList<>();

}
