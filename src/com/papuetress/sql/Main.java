package com.papuetress.sql;

import javax.swing.SwingUtilities;

public class Main {
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame run = new Frame();
				run.displayJFrame();
			}
		});
	}


}