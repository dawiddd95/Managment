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
        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getProductName() == name) {
                return product;
            }
        }

        return null;
    }

    public boolean checkIfExistByName(String name) {
        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getProductName() == name) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfExistById(Long id) {
        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfProductIsAvailable(String name) {
        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getProductName() == name && product.getProductCount() > 0) {
                return true;
            }
        }

        return false;
    }
}
