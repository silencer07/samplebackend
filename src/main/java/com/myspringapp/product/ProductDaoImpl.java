package com.myspringapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Set;

public class ProductDaoImpl implements ProductRepositoryCustom {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProductPrices(final long productId, @Nonnull final Map<String, BigDecimal> prices) {
        Product product = productDao.findOne(productId);

        if(product != null){
            Set<ProductPrice> existingPrices = product.getPrices();
            for(Map.Entry<String, BigDecimal> price : prices.entrySet()){
                ProductPrice productPrice = new ProductPrice();
                productPrice.setCurrency(Currency.getInstance(price.getKey()));
                productPrice.setPrice(price.getValue());
                productPrice.setProduct(product);

                existingPrices.add(productPrice);
            }

            productDao.save(product);
        } else {
            throw new DataRetrievalFailureException("Product not existing with ID:" + productId);
        }
    }
}
