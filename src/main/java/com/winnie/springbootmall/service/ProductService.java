package com.winnie.springbootmall.service;

import com.winnie.springbootmall.dto.ProductRequest;
import com.winnie.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
