package com.myspringapp.product;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Map;

public interface ProductRepositoryCustom {
    void addProductPrices(final long productId, @Nonnull final Map<String, BigDecimal> prices);
}
