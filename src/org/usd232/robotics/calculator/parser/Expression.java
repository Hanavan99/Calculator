package org.usd232.robotics.calculator.parser;

import org.usd232.robotics.calculator.calculator.Operand;
import org.usd232.robotics.calculator.service.IService;

public class Expression {

	private Expression a, b;
	private Operand o;
	
	public Expression(Operand o) {
		a = null;
		b = null;
		this.o = o;
	}
	
	public Expression(Expression a, Expression b, Operand o) {
		this.a = a;
		this.b = b;
		this.o = o;
	}
	
	public Expression(Expression a, double b, Operand o) {
		this.a = a;
		this.b = new Expression(o) {
			@Override
			public double evaluate(IService service) {
				return b;
			}
		};
		this.o = o;
	}
	
	public Expression(double a, Expression b, Operand o) {
		this.a = new Expression(o) {
			@Override
			public double evaluate(IService service) {
				return a;
			}
		};
		this.b = b;
		this.o = o;
	}
	
	public double evaluate(IService service) {
		return service.calculate(o, a.evaluate(service), b.evaluate(service));
	}
	
}
