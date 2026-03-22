package com.NextLevel.USA.ENTITIES;


import jakarta.persistence.*;

@Entity
@Table(name =  "product_images")
public class ProdctImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "products")
    private Products products;

  public  ProdctImages(){}

    public ProdctImages(Long id, String imageUrl, Products products) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
