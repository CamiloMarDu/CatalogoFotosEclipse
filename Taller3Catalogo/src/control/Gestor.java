package control;

//Importación de clases propias
import vista.WCatalogo;
//Importación de clases ajenas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestor implements ActionListener{

	private WCatalogo catalogo;
	public Gestor() {
		catalogo= new WCatalogo();
		catalogo.setVisible(true);
		catalogo.setResizable(false);
		catalogo.setLocationRelativeTo(null);
		catalogo.setTitle("Catálogo de Imágenes");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
