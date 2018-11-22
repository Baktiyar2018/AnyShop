package com.uraliev.anyshop.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Product extends RealmObject {
     @SerializedName("id")
     @PrimaryKey
     private  int id;

     @SerializedName("name")
     private  String name;

     @SerializedName("description")
     private  String description;

     @SerializedName("tagline")
     private  String tagline;

     @SerializedName("image_url")
     private  String image_url;
     //Region Constructor

     public Product() {
          this.id = 0;
          this.name = "";
          this.description = "";
          this.tagline = "";
          this.image_url = "";
     }
     public Product(int id,
                    String name,
                    String description,
                    String tagline,
                    String image_url) {
          this.id = id;
          this.name = name;
          this.description = description;
          this.tagline = tagline;
          this.image_url = image_url;
     }


     //endregion

     //Region Setter and Getter
     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getTagline() {
          return tagline;
     }

     public void setTagline(String tagline) {
          this.tagline = tagline;
     }

     public String getImage_url() {
          return image_url;
     }

     public void setImage_url(String image_url) {
          this.image_url = image_url;
     }
     //endregion


     @Override
     public String toString() {
          return id + " "
                  + name + " "
                  + description + " "
                  + tagline + " "
                  + image_url;
     }



    /* public Integer id;
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
*/
}
