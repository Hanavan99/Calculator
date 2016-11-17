package org.usd232.robotics.calculator.ui;

import org.usd232.robotics.calculator.calculator.Operand;
import org.usd232.robotics.calculator.service.ServiceManager;

/**
 * This is the console implementation of the IUI interface. This will be used
 * when we use the console.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public class ConsoleUI implements IUI {

	boolean exit = false;
	String val1 = "", val2 = "";
	double total;
	Operand o;
	
	@Override
	public void init() {
		ServiceManager.getService().printToConsole("Welcome to our calculator!\r\nPlease enter an equation to process.");
		while (exit == false) {
			String data = ServiceManager.getService().getConsoleInput();
			String[] parseddata = data.split(" ");
			for (String subdata : parseddata) {
				try {
					Double.parseDouble(subdata);
					
					if (val1.equals("")) {
						val1 = subdata;
						System.out.println("Set val1");
					} else if (val2.equals("")) {
						val2 = subdata;
						System.out.println("Set val2");
					} else {
						System.out.println("Did nothing");
					}
				} catch (NumberFormatException e) {
					
					if (o != null && !val1.equals("") && !val2.equals("")) {
						calculate();
					} else {
						switch (subdata) {
						case "=":
							calculate();
							break;
						case "+":
							o = Operand.ADD;
							break;
						case "-":
							o = Operand.SUBTRACT;
							break;
						case "*":
							o = Operand.MULTIPLY;
							break;
						case "/":
							o = Operand.DIVIDE;
							break;
						case "sin":
							o = Operand.SINE;
							break;
						}
						System.out.println("Set operand");
					}
					
				}
			}
			ServiceManager.getService().printResultToConsole(String.valueOf(total));
			total = 0;
			val1 = "";
			val2 = "";
		}
	}

	@Override
	public void shutdown() {
		
	}
	
	private void calculate() {
		if (val1.equals("")) {
			val1 = "0";
		}
		if (val2.equals("")) {
			val2 = "0";
		}
		total += ServiceManager.getService().calculate(o, Double.valueOf(val1), Double.valueOf(val2));
		o = null;
		val1 = "";
		val2 = "";
		System.out.println("Computed result");
	}

}
