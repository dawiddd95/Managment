package com.company.api;

import com.company.entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {
    void saveProduct(Product product) throws IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;

    List<Product> getAllProducts() throws IOException;
}
