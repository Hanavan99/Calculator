package org.usd232.robotics.calculator.calculator;

public enum Operand {

	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	MODULO("mod"),
	EXPONENT("^"),
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
