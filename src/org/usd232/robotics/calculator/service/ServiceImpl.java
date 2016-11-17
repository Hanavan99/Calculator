package org.usd232.robotics.calculator.service;

import java.util.Scanner;

import org.usd232.robotics.calculator.calculator.Operand;
import org.usd232.robotics.calculator.main.Config;

public class ServiceImpl implements IService {

	private final Config cfg;
	private final Scanner scanner;

	public ServiceImpl(Config cfg) {
		this.cfg = cfg;
		scanner = new Scanner(System.in);
	}

	@Override
	public double calculate(Operand o, double... args) {
		if (args.length < 2) {
			throw new IllegalArgumentException("You must specify at least two numbers to calculate with!");
		} else {
			switch (o) {
			case ADD:
				return args[0] + args[1];
			case MULTIPLY:
				return args[0] * args[1];
			case DIVIDE:
				return args[0] / args[1];
			case SINE:
				return Math.sin(args[0]);
			default:
				return 0;
			}
		}
	}

	@Override
	public String getConsoleInput() {
		return scanner.nextLine();
	}

	@Override
	public void printToConsole(String result) {
		System.out.println("Computed answer: " + result);
	}

	@Override
	public void printResultToConsole(String text) {
		System.out.println(text);
	}

}
