package com.company.api;

import com.company.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;
    Product getProductByProductName(String productName) throws IOException;

    boolean isProductExist(String productName);

    boolean saveProduct(Product product);
}
