package org.usd232.robotics.calculator.service;

import org.usd232.robotics.calculator.calculator.Operand;

/**
 * This is where all of the functionality of the calculator is created.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public interface IService {

	public double calculate(Operand o, double... args);
	
	public String getConsoleInput();
	
	public void printToConsole(String text);
	
	public void printResultToConsole(String result);
	
}
