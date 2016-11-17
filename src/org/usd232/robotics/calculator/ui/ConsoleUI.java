package org.usd232.robotics.calculator.ui;

import java.util.Arrays;

import org.usd232.robotics.calculator.calculator.Operand;
import org.usd232.robotics.calculator.service.IService;
import org.usd232.robotics.calculator.service.ServiceManager;

/**
 * This is the console implementation of the IUI interface. This will be used
 * when we use the console.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public class ConsoleUI implements IUI {

	private boolean exit = false;
	private Operand o;
	private String[] operands = new String[] {"+", "-", "*", "/", "^", "mod"};

	@Override
	public void init() {
		// Get the service and store it to a variable for ease of access
		IService svc = ServiceManager.getService();
		svc.printToConsole("Welcome to our calculator!\r\nPlease enter an equation to process.");

		// Start looping
		while (exit == false) {
			// Define variables
			String val1 = "", val2 = "", operand = "";
			
			// Get first value and cleanse
			boolean gtg = false;
			while (gtg == false) {
				svc.printToConsole("Enter first value:");
				val1 = svc.getConsoleInput();
				try {
					Double.parseDouble(val1);
					gtg = true;
				} catch (NumberFormatException e) {
					svc.printToConsole("Not a valid number!");
				}
			}

			// Get second value
			gtg = false;
			while (gtg == false) {
				svc.printToConsole("Enter second value:");
				val2 = svc.getConsoleInput();
				try {
					Double.parseDouble(val2);
					gtg = true;
				} catch (NumberFormatException e) {
					svc.printToConsole("Not a valid number!");
				}
			}

			// Get operand
			gtg = false;
			while (!gtg) {
				svc.printToConsole("Enter operand:");
				operand = svc.getConsoleInput();
				if (!Arrays.asList(operands).contains(operand)) {
					svc.printToConsole("Not a valid operand!");
				} else {
					gtg = true;
				}
			}

			// Figure out which operand they gave
			switch (operand) {
				case "+" :
					o = Operand.ADD;
					break;
				case "-" :
					o = Operand.SUBTRACT;
					break;
				case "*" :
					o = Operand.MULTIPLY;
					break;
				case "/" :
					o = Operand.DIVIDE;
					break;
				case "^" :
					o = Operand.EXPONENT;
					break;
				case "mod" :
					o = Operand.MODULO;
					break;
			}

			// Convert strings to doubles
			double num1 = Double.valueOf(val1);
			double num2 = Double.valueOf(val2);

			// Find and print the result
			svc.printResultToConsole(String.valueOf(svc.calculate(o, num1, num2)));
			
			// Ask if they want to do another calculation
			svc.printToConsole("Do you want to do another calculation?");
			if (!svc.getConsoleInput().toLowerCase().contains("y")) {
				exit = true;
			}
		}
	}

	@Override
	public void shutdown() {

	}

}
