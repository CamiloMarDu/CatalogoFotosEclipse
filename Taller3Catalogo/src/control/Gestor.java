package control;

//Importación de clases propias
import vista.WCatalogo;
//Importación de clases ajenas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Gestor implements ActionListener {
	File[] files;
	private WCatalogo catalogo;

	public Gestor() {
		catalogo = new WCatalogo();
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

		switch (e.getActionCommand()) {
		case "salir":
			cerrarVentana(this.catalogo.avisoCerrarVentana());
			break;
		case "buscarCarpeta":

			break;
		}
	}

	public void ImageFolderChooser() {
		File[] files;
		// Crear un JFileChooser
		JFileChooser fileChooser = new JFileChooser();

		// Configurar el JFileChooser para que solo muestre directorios
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// Mostrar el cuadro de diálogo de selección de archivos
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			// Obtener la carpeta seleccionada
			File selectedFolder = fileChooser.getSelectedFile();

			// Obtener todos los archivos en la carpeta seleccionada
			files = selectedFolder.listFiles();

			if (files != null) {
				// Filtrar solo los archivos de imagen (por ejemplo, jpg, png, etc.)
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "jpeg", "png", "gif");

			} else {
				System.out.println("La carpeta seleccionada está vacía.");

			}
		} else {
			System.out.println("Operación cancelada por el usuario.");

		}

	}

	public double progreso(File[] files) {
		double porcentaje = 100 / files.length;
		return porcentaje;
	}

}
