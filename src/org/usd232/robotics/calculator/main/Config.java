package org.usd232.robotics.calculator.main;

/**
 * This is the configuration that is used to tell the service which type of UI
 * to return.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public class Config {

	private final boolean isGraphical;

	public Config(boolean isGraphical) {
		this.isGraphical = isGraphical;
	}

	public boolean isGraphical() {
		return isGraphical;
	}
	
}
