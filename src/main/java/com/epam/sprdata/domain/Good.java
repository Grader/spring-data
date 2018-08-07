package com.epam.sprdata.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cat;

    private String tag;

    private String price;

    private String img;

    @ManyToMany
    @JoinTable(
            name = "carts_goods", joinColumns = {@JoinColumn(name = "good_id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id")})
    private Set<Cart> carts = new HashSet<>();

    public Good(String cat, String tag, String price, String img) {
        this.cat = cat;
        this.tag = tag;
        this.price = price;
        this.img = img;
    }

    public Good() {
    }

    public String getCat() {
        return cat;
    }


    public Long getId() {
        return id;
    }


    public String getTag() {
        return tag;
    }


    public String getPrice() {
        return price;
    }


    public String getImg() {
        return img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setTag(String name) {
        this.tag = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
}
