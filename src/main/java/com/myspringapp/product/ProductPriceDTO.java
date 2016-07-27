package com.myspringapp.product;

import java.math.BigDecimal;
import java.util.Map;

public class ProductPriceDTO {
    private long productId;
    private Map<String, BigDecimal> prices;

    public long getProductId() {
        return productId;
    }

    public void setProductId(final long productId) {
        this.productId = productId;
    }

    public Map<String, BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(final Map<String, BigDecimal> prices) {
        this.prices = prices;
    }
}
