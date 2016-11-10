package org.usd232.robotics.calculator.calculator;

public enum Operand {

	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	MODULO("mod"),
	EXPONENT("^"),
	SINE("sin()"),
	COSINE("cos()"),
	TANGENT("tan()"),
	ASINE("asin()"),
	ACOSINE("acos()"),
	ATANGENT("atan()"),
	CLEAR("C"),
	CLEARENTRY("CE");
	
	private String name;
	
	private Operand(String name) {
		this.name= name;
	}
	
	public String getName() {
		return name;
	}
	
}
