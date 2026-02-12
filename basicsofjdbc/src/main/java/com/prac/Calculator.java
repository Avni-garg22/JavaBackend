package com.prac;

public class Calculator {
	public static int add(int a,int b) {
	return a+b;
	}

	public static String  reverseString(String s) {
		String rev="";
		for(int i=s.length()-1;i>=0;i--) { //do one mistake to test
			rev=rev+s.charAt(i);
		}
		return rev;
	}
	
	public static int div(int a,int b) {
		return a/b;
	}
	
	//framework junit help we take
	
}
