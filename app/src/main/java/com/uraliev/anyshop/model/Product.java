package com.uraliev.anyshop.model;

public class Product {
     public Integer id;
     public String name;
     public String description;
     public String url;

     public Product (
             Integer id,
             String name,
             String description,
             String url
     ){
          this.id = id;
          this.name = name;
          this.description = description;
          this.url = url;
     }

}
