package org.usd232.robotics.calculator.main;

import org.usd232.robotics.calculator.service.ServiceManager;
import org.usd232.robotics.calculator.ui.ConsoleUI;
import org.usd232.robotics.calculator.ui.GraphicalUI;
import org.usd232.robotics.calculator.ui.IUI;

public class Main {

	public static void main(String[] args) {

		Config cfg;

		if (args.length < 1) {
			System.out.println("Assuming that you don't want to run with a GUI");
			cfg = new Config(false);
		} else {
			cfg = new Config(args[0].equals("graphics"));
		}
		ServiceManager.init(cfg);

		IUI ui;
		if (cfg.isGraphical()) {
			ui = new GraphicalUI();
		} else {
			ui = new ConsoleUI();
		}
		ui.init();

	}

}