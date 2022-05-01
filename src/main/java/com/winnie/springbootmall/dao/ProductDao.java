package com.winnie.springbootmall.dao;
import org.springframework.data.repository.CrudRepository;
import com.winnie.springbootmall.model.Product;

public interface ProductDao extends CrudRepository<Product,Integer>{
}
