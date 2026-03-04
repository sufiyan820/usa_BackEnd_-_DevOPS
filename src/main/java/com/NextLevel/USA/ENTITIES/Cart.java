package com.NextLevel.USA.ENTITIES;


import com.NextLevel.USA.DTO0.Response.CartItemResponseDTO;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String userEmail;

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartItems> items = new ArrayList<>();


    public  Cart(){}

    public Cart(String userEmail){
        this.userEmail = userEmail;
    }

    public Cart(Long id, String userEmail, List<CartItems> items) {
        this.id = id;
        this.userEmail = userEmail;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<CartItems> getItems() {
        return items;
    }

    public void setItems(List<CartItems> items) {
        this.items = items;
    }
}
