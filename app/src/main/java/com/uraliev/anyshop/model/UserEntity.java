package com.uraliev.anyshop.model;

// Created by askar on 11/2/18.
public class UserEntity {
    public String name;
    public String password;
    public String country;

    public UserEntity(
            String name,
            String password,
            String country
    ){
        this.name = name;
        this.password = password;
        this.country = country;
    }
}
