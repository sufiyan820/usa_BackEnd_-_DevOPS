package com.NextLevel.USA.ENTITIES;

import com.NextLevel.USA.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int stock;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    @JoinColumn(name = "category_id", nullable = false)  // so yahan NULL nahi hogga database mei
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @Column(nullable = false)
    private boolean available = true;


    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdctImages> images;


    // ✅ Required by JPA
    public Products() {
    }


    public Products(Long id, String name, int stock, String description, String manufacturer, BigDecimal price, String category, ProductStatus status, boolean available) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
        this.status = status;
        this.available = available;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}