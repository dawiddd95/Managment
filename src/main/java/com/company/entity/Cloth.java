package com.company.entity;

import com.company.entity.enums.Color;
import com.company.entity.enums.Material;
import com.company.entity.enums.ProductSeparators;

public class Cloth extends Product {
    private String size;
    private Material material;

    public Cloth(Long id, String productName, Float price, Float weight, Color color, Integer productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }


    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.ClOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
    }
}
