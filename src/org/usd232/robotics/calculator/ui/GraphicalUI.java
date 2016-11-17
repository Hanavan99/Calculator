package org.usd232.robotics.calculator.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
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
	
	private Font textFont = new Font("Arial", Font.PLAIN, 20);
	private Font buttonFont = new Font("Arial", Font.PLAIN, 26);
	
	private Color windowBgColor = new Color(0, 0, 0);
	private Color textBgColor = new Color(31, 31, 31);
	private Color textFgColor = new Color(0, 255, 0);
	private Color buttonBgColor = new Color(31, 31, 31);
	private Color buttonFgColor = new Color(255, 0, 0);

	@Override
	public void init() {
		layout = new GridLayout(7, 3);
		layout.setHgap(5);
		layout.setVgap(5);

		window = new Frame("Calculator");
		window.setLayout(null);
		window.setBounds(100, 100, 230, 395);
		window.setBackground(windowBgColor);
		window.setResizable(false);
		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				shutdown();
			}
		});

		TextField num = new TextField();
		num.setBounds(15, 40, 200, 30);
		num.setFont(textFont);
		num.setBackground(textBgColor);
		num.setForeground(textFgColor);
		num.setEditable(false);
		num.setFocusable(false);
		window.add(num);

		Panel buttons = new Panel();
		buttons.setBounds(15, 80, 201, 300);
		buttons.setLayout(layout);
		window.add(buttons);
		
		for (int i = 0; i < 11; i++) {
			Button b = new Button(i == 10 ? "." : String.valueOf(i));
			b.setFont(buttonFont);
			b.setBackground(buttonBgColor);
			b.setForeground(buttonFgColor);
			buttons.add(b);
			b.addActionListener((ActionEvent e) -> {
				val1 += b.getLabel();
				num.setText(val1);
			});
		}

		for (Operand o : Operand.values()) {
			Button b = new Button(o.getName());
			b.setFont(buttonFont);
			b.setBackground(buttonBgColor);
			b.setForeground(buttonFgColor);
			buttons.add(b);
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
		equals.setFont(buttonFont);
		equals.setBackground(buttonBgColor);
		equals.setForeground(buttonFgColor);
		buttons.add(equals);
		equals.addActionListener((ActionEvent e) -> {
			if (val2.equals("")) {
				num.setText(val1);
			} else {
				val1 = String.valueOf(ServiceManager.getService().calculate(op, Double.valueOf(val1), Double.valueOf(val2)));
				num.setText(val1);
				val1 = "";
				val2 = "";
			}
		});
	}

	@Override
	public void shutdown() {
		window.setVisible(false);
		window.dispose();
	}

}
