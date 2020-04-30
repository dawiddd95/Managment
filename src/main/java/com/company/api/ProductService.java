package com.company.api;

import com.company.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    int getAmountOfProducts();
    Product getProductByName(String name);
    boolean checkIfExistByName(String name);
    boolean checkIfExistById(Long id);
    boolean checkIfProductIsAvailable(String name);
}
