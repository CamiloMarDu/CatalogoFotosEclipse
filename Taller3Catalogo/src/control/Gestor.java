package control;

//Importación de clases propias
import vista.WCatalogo;

import java.awt.Color;
import java.awt.Dimension;

//Importación de clases ajenas

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;


public class Gestor implements ActionListener {

    private WCatalogo catalogo;
    private List<File> imageFiles; // Lista para almacenar los archivos de imagen

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
        
        // Inicializar la lista de archivos de imagen
        imageFiles = new ArrayList<>();
    }


    public void cerrarVentana(int val) {
        if (val == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

		


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salir":
                cerrarVentana(this.catalogo.avisoCerrarVentana());
                break;
            case "buscarCarpeta":
                cargarImagenes();
                //Direcciones de prueba --------------------------------------------------
                String direccionCarpeta="C:\\Users\\juanc\\OneDrive\\Desktop\\fotos messi\\";
                String direccionCarpetaYo="C:\\Users\\Camilo\\Pictures\\Fotos\\";
                
                cicloBotones(imageFiles.size(),imageFiles, direccionCarpetaYo);
                this.catalogo.enConsola(imageFiles.size());
               
                break;
        }
    }

    public void chooseImageFolder() {
        // Crear un JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Configurar el JFileChooser para que solo muestre directorios
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Agregar filtro para archivos de imagen
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "png");
        fileChooser.setFileFilter(filter);

        // Mostrar el cuadro de diálogo de selección de archivos
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener la carpeta seleccionada
            File selectedFolder = fileChooser.getSelectedFile();

            // Verificar si la carpeta contiene archivos
            if (selectedFolder.isDirectory()) {
                // Obtener todos los archivos en la carpeta seleccionada
                File[] files = selectedFolder.listFiles();

                // Verificar si hay archivos en la carpeta seleccionada
                if (files != null && files.length > 0) {
                    // Agregar solo los archivos de imagen a la lista
                    for (File file : files) {
                        if (filter.accept(file)) {
                            imageFiles.add(file);
                        }
                    }
                } else {
                	this.catalogo.enConsola("La carpeta seleccionada está vacía o no contiene archivos de imagen.");
                }
            } else {
            	this.catalogo.enConsola("La ruta seleccionada no es una carpeta.");
            }
        } else {
        	this.catalogo.enConsola("Operación cancelada por el usuario.");
        }
    }

    public List<File> getImageFiles() {
        return imageFiles;
    }

    public void cargarImagenes() {
        chooseImageFolder();

        // Obtener y mostrar los archivos de imagen seleccionados
        if (!imageFiles.isEmpty()) {
        	this.catalogo.enConsola("Archivos de imagen seleccionados:");
            for (File file : imageFiles) {
                this.catalogo.enConsola(file.getAbsolutePath());
            }
        } else {
        	this.catalogo.enConsola("No se seleccionaron archivos de imagen.");
        }
    }
public void cicloBotones(int cant, List<File> imagen, String dirCarpeta) {
		
		//ScrollPane
		this.catalogo.scrollPane.setBounds(20, 79, 927, 433);
		this.catalogo.contentPane.add(this.catalogo.scrollPane);
		
		this.catalogo.panelImagenesOprimibles.setBackground(Color.black);
		this.catalogo.scrollPane.setViewportView(this.catalogo.panelImagenesOprimibles);
		this.catalogo.panelImagenesOprimibles.setLayout(null);
		
		for (int i = 0; i < cant; i++) {
			
	    	   this.catalogo.panelImagenesOprimibles.setPreferredSize(new Dimension((i+1)*400,40));
	    	   
	    	   JButton boton=new JButton();
	    	   int posFin=i*400;
	    	   boton.setBounds(posFin,5,400,400);
	    	   this.catalogo.imagenEnBoton(dirCarpeta+imagen.get(i).getName(), boton);
	    	   
	    	   boton.addActionListener(new ActionListener() {
	               @Override
	               public void actionPerformed(ActionEvent e1) {
	            	   new GestorVisor();
	                  
	                  
	                  
	               }
	           });
		}
	}
}