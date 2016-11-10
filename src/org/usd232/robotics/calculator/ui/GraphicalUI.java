package org.usd232.robotics.calculator.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.usd232.robotics.calculator.calculator.Operand;
import org.usd232.robotics.calculator.service.ServiceManager;

/**
 * This is the graphical implementation of the IUI interface. It will be used
 * when we use the UI.
 * 
 * @author Hanavan Kuhn (Change this)
 *
 */
public class GraphicalUI implements IUI {

	private Frame window;

	private String val1 = "", val2 = "";

	private GridLayout layout;

	private Operand op;

	@Override
	public void init() {
		layout = new GridLayout(12, 3);
		layout.setHgap(5);
		layout.setVgap(5);

		window = new Frame("Calculator");
		window.setLayout(layout);
		window.setLocation(100, 100);
		window.setBackground(new Color(0, 0, 255));
		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				shutdown();
			}
		});

		TextField num = new TextField();
		num.setBounds(20, 40, 180, 30);
		num.setEditable(false);
		num.setFocusable(false);
		window.add(num);

		for (int i = 0; i < 10; i++) {
			Button b = new Button(String.valueOf(i));
			window.add(b);
			b.addActionListener((ActionEvent e) -> {
				val1 += b.getLabel();
				num.setText(val1);
			});
		}

		for (Operand o : Operand.values()) {
			Button b = new Button(o.getName());
			window.add(b);
			b.addActionListener((ActionEvent e) -> {
				if (val2.equals("")) {
					val2 = val1;
					val1 = "";
					num.setText(val1);
					op = o;
				} else {
					val1 = String.valueOf(ServiceManager.getService().calculate(op, Double.valueOf(val1), Double.valueOf(val2)));
				}
			});
		}

		Button equals = new Button("=");
		window.add(equals);
		equals.addActionListener((ActionEvent e) -> {
			if (val2.equals("")) {
				num.setText(val1);
			} else {
				val1 = String.valueOf(ServiceManager.getService().calculate(op, Double.valueOf(val1), Double.valueOf(val2)));
				num.setText(val1);
			}
		});

		window.pack();
	}

	@Override
	public void shutdown() {
		window.setVisible(false);
		window.dispose();
	}

}
