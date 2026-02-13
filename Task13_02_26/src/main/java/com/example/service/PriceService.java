package com.example.service;

public class PriceService {
    private Discount discountRepository;

    public PriceService(Discount discountRepository) {
        this.discountRepository = discountRepository;
    }

    public double calculateFinalPrice(double price, String productCode) {
        double discount = discountRepository.getDiscountPercentage(productCode);
        return price - (price * discount / 100);
    }
}
