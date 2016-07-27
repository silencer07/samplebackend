package com.myspringapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/products/addPrices")
    public @ResponseBody Product addProductPrices(@RequestBody final ProductPriceDTO productPriceDTO){
        productRepository.addProductPrices(productPriceDTO.getProductId(), productPriceDTO.getPrices());
        return productRepository.findOne(productPriceDTO.getProductId());
    }

}
