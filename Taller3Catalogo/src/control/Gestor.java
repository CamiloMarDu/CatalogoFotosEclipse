package control;

//Importación de clases propias
import vista.WCatalogo;
//Importación de clases ajenas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Gestor implements ActionListener{

	private WCatalogo catalogo;
	public Gestor() {
		catalogo= new WCatalogo();
		catalogo.setVisible(true);
		catalogo.setResizable(false);
		catalogo.setLocationRelativeTo(null);
		catalogo.setTitle("Catálogo de Imágenes");
		
		// SECCION DE ACTION LISTENERS DE LOS BOTONES
		this.catalogo.getBtnBuscarDirectorio().addActionListener(this);
		this.catalogo.getBtnBuscarDirectorio().setActionCommand("buscarCarpeta");

		this.catalogo.getBtnSalir().addActionListener(this);
		this.catalogo.getBtnSalir().setActionCommand("salir");
	}
	
	public void cerrarVentana(int val) {
		if (val == JOptionPane.YES_NO_OPTION) {
			System.exit(0);			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (("salir").equals(e.getActionCommand())) {
			cerrarVentana(this.catalogo.avisoCerrarVentana());
			
		} else if (("buscarCarpeta").equals(e.getActionCommand())) {
			
			
		}
	}

}
