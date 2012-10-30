package rts.lab04;

import java.awt.EventQueue;

public class Run {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
