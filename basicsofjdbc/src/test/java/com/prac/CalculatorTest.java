package com.prac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	public void addTest() {
		int res=Calculator.add(20, 30);
	}
	
//	@Test
//	public void reverseTest() {
//		String actualres=Calculator.reverseString("Avni");
//		//invA(expected)--nvA(give)
//		//ist assertion is equals	
//		assertEquals("invA",actualres);
//		
//	}
	
//	@Test
//	public void reverseTestNull() {
//		String actualRes=Calculator.reverseString(null);
//		assertEquals("llun",actualRes);
//	}
	
	@Test
	public void testValidAge() {
		Employee e=new Employee(101,"avni",20,"cse");
		assertFalse(e.isValidAge());
	}
	
//	@Test
//	public void testValidName() {
//		Employee e=new Employee(101,"avni",20,"cse");
//		assertTrue(e.isValidName());
//	}
	
	@Test
	public void testAEEx() {
		
		Calculator c=new Calculator();
		assertThrows(ArithmeticException.class,()->{c.div(10,0);});
	}


}
