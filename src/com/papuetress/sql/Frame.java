package com.papuetress.sql;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Frame {
	public static JFrame frame;
	 void displayJFrame() {

		frame = new JFrame("SQL Read and Write");

		// create our jbutton
		JButton button1 = new JButton("Insert Data");
		JButton button2 = new JButton("Scan Email Address");
		JButton button3 = new JButton("Save Table to File");

		// add the listener to the jbutton to handle the "pressed" event
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sql start = new Sql();
				start.sqlCheck1();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Sql start = new Sql();
				start.sqlCheck2();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sql start = new Sql();
				start.sqlCheck3();
			}
		});
		// put the button on the frame
		frame.getContentPane().setLayout(new FlowLayout());
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(new JLabel(new ImageIcon(
				"res/image.png")));

		// set up the jframe, then display it
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(360, 360));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
