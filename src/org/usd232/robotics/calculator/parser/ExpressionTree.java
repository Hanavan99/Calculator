package org.usd232.robotics.calculator.parser;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpressionTree {

	private HashMap<Expression, Integer> tree = new HashMap<Expression, Integer>();
	
	public ExpressionTree() {
		
	}
	
	public void addExpression(Expression e, int pos) {
		tree.put(e, pos);
	}
	
	public ArrayList<Expression> getExpressionsOfTier(int tier) {
		ArrayList<Expression> expressions = new ArrayList<Expression>();
		for (Expression e : tree.keySet()) {
			if (tree.get(e) >= tier) {
				expressions.add(e);
			}
		}
		return expressions;
	}
	
}
