package com.company.service;

import com.company.api.ProductService;
import com.company.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getAmountOfProducts() {
        return products.size();
    }

    public Product getProductByName(String name) {
        for(Product product : products) {
            if(product.getProductName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    public boolean checkIfExistByName(String name) {
        for(Product product : products) {
            if(product.getProductName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfExistById(Long id) {
        for(Product product : products) {
            if(product.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfProductIsAvailable(String name) {
        for(Product product : products) {
            if(product.getProductName().equals(name) && product.getProductCount() > 0) {
                return true;
            }
        }

        return false;
    }
}
