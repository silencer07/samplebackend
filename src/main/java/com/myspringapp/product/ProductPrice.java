package com.myspringapp.product;

import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nonnull;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
public class ProductPrice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @NotNull
    private Product product;

    @Column
    @NotBlank
    private String currency = "USD";

    @Column
    @NotNull
    @DecimalMin("0.00")
    private BigDecimal price = BigDecimal.ZERO;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(@Nonnull final Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Nonnull final BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(@Nonnull Currency currency) {
        this.currency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(currency);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final ProductPrice that = (ProductPrice) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(product, that.product)
                .append(currency, that.currency)
                .append(price, that.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(product)
                .append(currency)
                .toHashCode();
    }
}
