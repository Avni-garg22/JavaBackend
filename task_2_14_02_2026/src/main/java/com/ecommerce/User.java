package com.ecommerce;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PurchaseOrder> orders;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<PurchaseOrder> getOrders() { return orders; }
    public void setOrders(List<PurchaseOrder> orders) { this.orders = orders; }
}