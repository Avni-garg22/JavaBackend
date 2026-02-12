package com.product_hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.prac.Calculator;


public class CalculatorTest {
@Test
	public void divideTest() {
		Calculator c=new Calculator();
		int actualRes=c.divide(10,2);
		assertEquals(5,actualRes);
	}

@Test
public void divideTestZero() {
	Calculator c=new Calculator();
	int actualRes=c.divide(10, 0);
	assertEquals(0,actualRes);
}
}
