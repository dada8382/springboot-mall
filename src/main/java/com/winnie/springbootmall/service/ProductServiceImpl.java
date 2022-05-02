package com.winnie.springbootmall.service;

import com.winnie.springbootmall.dao.ProductDao;
import com.winnie.springbootmall.dto.ProductRequest;
import com.winnie.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.findById(productId).orElse(null);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        Date now = new Date();
        product.setCreateDate(now);
        product.setLastModifiedDate(now);
        return productDao.save(product).getProductId();
    }
    @Override
    public void updateProduct(Integer productId,ProductRequest productRequest) {
        Product product = productDao.findById(productId).orElse(null);
        product.setProductName(productRequest.getProductName());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        Date now = new Date();
        product.setLastModifiedDate(now);
        productDao.save(product);
    }
    @Override
    public void deleteProduct(Integer productId) {
        Product product = productDao.findById(productId).orElse(null);
        if (product!=null) {
            productDao.delete(product);
        }
    }
}
