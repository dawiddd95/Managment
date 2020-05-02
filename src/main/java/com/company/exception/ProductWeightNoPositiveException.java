package com.company.exception;

public class ProductWeightNoPositiveException extends Exception {
    public ProductWeightNoPositiveException() {
    }

    public ProductWeightNoPositiveException(String message) {
        super(message);
    }
}
