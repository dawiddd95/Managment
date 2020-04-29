package com.company.entity;

public class Boots extends Product {
    private Integer size;
    private Boolean isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, Boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public Integer getSize() {
        return size;
    }

    public Boolean getNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString() + "Boots{" +
                "size='" + size + '\'' +
                ", isNaturalSkin=" + isNaturalSkin +
                '}';
    }
}
