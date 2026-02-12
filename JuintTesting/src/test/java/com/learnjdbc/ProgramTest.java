package com.learnjdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.connectDataBase.EvenOrOdd;
import com.connectDataBase.Programm;

public class ProgramTest {

//	@ParameterizedTest
	//@ValueSource(strings= {"tenet","radar","aba","abcd"})
	public void isPalindromeTest(String str) {
		Programm p=new Programm();
		
		assertTrue(p.isPalindrome(str));
		
	}
	
//	@ParameterizedTest
//	@CsvSource({
//		"1,2,3",
//		"5,5,10", 
//		"5,3,7"
//	})
public void addTest(int a,int b,int expectedresult) {
		Programm p=new Programm();
		int actual=p.add(a, b);
		assertEquals(expectedresult,actual);
	
}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgeminiJDBC.csv",numLinesToSkip = 1 )
	public void evenOroddTest(String input,String expected) {
		EvenOrOdd eoo=new  EvenOrOdd();
		String actualres=eoo.evenOrOdd(Integer.parseInt(input));
		assertEquals(expected,actualres);
		
	}
}
