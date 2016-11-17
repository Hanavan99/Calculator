package org.usd232.robotics.calculator.service;

import java.util.Scanner;

import org.usd232.robotics.calculator.calculator.Operand;

public class ServiceImpl implements IService {

	private final Scanner scanner;

	public ServiceImpl() {
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
			case SUBTRACT:
				return args[0] - args[1];
			case MULTIPLY:
				return args[0] * args[1];
			case DIVIDE:
				return args[0] / args[1];
			case EXPONENT:
				return Math.pow(args[0], args[1]);
			case MODULO:
				return args[0] % args[1];
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
	public void printResultToConsole(String result) {
		System.out.println("Computed answer: " + result);
	}

	@Override
	public void printToConsole(String text) {
		System.out.println(text);
	}

}
