package com.company.entity;

import com.company.entity.enums.Color;
import com.company.entity.enums.ProductSeparators;
import com.company.entity.enums.SkinType;

public class Boots extends Product {
    public final static char PRODUCT_TYPE = 'B';

    private Integer size;
    private SkinType skinType;

    public Boots(Long id, String productName, Float price, Float weight, Color color, Integer productCount, Integer size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public Integer getSize() {
        return size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + skinType;
    }
}
