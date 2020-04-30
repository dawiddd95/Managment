package com.company.api;

import com.company.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Integer getAmountOfProducts();
    Product getProductByName(String productName);
    Boolean checkIfExistByName(String productName);
    Boolean checkIfExistById(Long id);
}
