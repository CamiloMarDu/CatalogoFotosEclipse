package control;

import java.awt.EventQueue;


public class CatalogoDeFotos {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Gestor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
