package com.company.api;

import com.company.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    int getAmountOfProducts();
    Product getProductByName(String name);
    boolean isProductExist(String name);
    boolean isProductExist(Long id);
    boolean isProductAvailable(String name);
}
