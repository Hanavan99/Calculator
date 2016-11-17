package org.usd232.robotics.calculator.parser;

public class ParserUtils {

	public static String getSubstringBetween(String data, char start, char end) {
		int tier = 0;
		char[] array = data.toCharArray();
		String substring = "";
		for (int i = 0; i < data.length(); i++) {
			if (array[i] == start) {
				tier++;
			}
			if (array[i] == end) {
				tier--;
			}
			if (tier > 0) {
				substring += String.valueOf(array[i]);
			}
		}
		return substring;
	}
	
	public static String getFirstExpression(String data) {
		char[] array = data.toCharArray();
		String expression = "";
		for (int i = 0; i < data.length(); i++) {
			if (Character.isDigit(array[i])) {
				expression += String.valueOf(array[i]);
			}
			
			// TODO not finished
		}
		return expression;
	}
	
}
