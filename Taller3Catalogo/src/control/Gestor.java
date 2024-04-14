package control;

//Importación de clases propias
import vista.WCatalogo;


//Importación de clases ajenas

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.util.ArrayList;
import java.util.List;




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
                this.catalogo.cicloBotones(imageFiles.size(),imageFiles);
                System.out.print(imageFiles.size());
               
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
                    System.out.println("La carpeta seleccionada está vacía o no contiene archivos de imagen.");
                }
            } else {
                System.out.println("La ruta seleccionada no es una carpeta.");
            }
        } else {
            System.out.println("Operación cancelada por el usuario.");
        }
    }

    public List<File> getImageFiles() {
        return imageFiles;
    }

    public void cargarImagenes() {
        chooseImageFolder();

        // Obtener y mostrar los archivos de imagen seleccionados
        if (!imageFiles.isEmpty()) {
            System.out.println("Archivos de imagen seleccionados:");
            for (File file : imageFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No se seleccionaron archivos de imagen.");
        }
    }
}