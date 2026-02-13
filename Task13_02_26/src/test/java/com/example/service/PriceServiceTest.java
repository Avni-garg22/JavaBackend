package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    private Discount discountRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setup() {
        // Mockitoo automatically injects mocks
    }

    @Test
    void testCalculateFinalPrice_MOB() {
        when(discountRepository.getDiscountPercentage("MOB"))
                .thenReturn(10.0);

        double finalPrice = priceService.calculateFinalPrice(1000, "MOB");

        assertEquals(900, finalPrice);
        verify(discountRepository).getDiscountPercentage("MOB");
    }

    @Test
    void testCalculateFinalPrice_LAP() {
        when(discountRepository.getDiscountPercentage("LAP"))
                .thenReturn(20.0);

        double finalPrice = priceService.calculateFinalPrice(2000, "LAP");

        assertEquals(1600, finalPrice);
        verify(discountRepository).getDiscountPercentage("LAP");
    }


    @Test
    void testCalculateFinalPrice_Exception() {
        when(discountRepository.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("Service unavailable"));

        assertThrows(RuntimeException.class, () -> {
            priceService.calculateFinalPrice(1000, "ERR");
        });

        verify(discountRepository).getDiscountPercentage("ERR");
    }
}
