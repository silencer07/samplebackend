package com.myspringapp.product;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name= "id"))
    private Set<String> tags = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductPrice> prices = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@Nonnull final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@Nonnull final String description) {
        this.description = description;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(@Nonnull final Set<String> tags) {
        this.tags = tags;
    }

    public Set<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(final Set<ProductPrice> prices) {
        this.prices = prices;
    }
}
