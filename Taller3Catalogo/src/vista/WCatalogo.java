package vista;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * La clase WCatalogo representa la ventana de catálogo de imágenes.
 */
public class WCatalogo extends JFrame {
	 /** El panel principal de la interfaz. */
    public JPanel contentPane;

    /** Etiqueta para mostrar el mensaje de búsqueda. */
    private JLabel lblBusqueda;

    /** Botón para buscar directorio. */
    private JButton btnBuscarDirectorio;

    /** Botón para salir de la aplicación. */
    private JButton btnSalir;

    /** Scroll pane para la visualización de imágenes. */
    public JScrollPane scrollPane;

    /** Panel que contiene las imágenes oprimibles. */
    public JPanel panelImagenesOprimibles;
    
    /**
     * Constructor de la clase. Inicia la interfaz gráfica del catálogo.
     */
	
	//Getters y setters botones
	
	/**
	 * Retorna el botón para buscar directorio.
	 * @return El botón para buscar directorio.
	 */
	public JButton getBtnBuscarDirectorio() {
		return btnBuscarDirectorio;
	}

	/**
	 * Establece el botón para buscar directorio.
	 * @param btnBuscarDirectorio El botón para buscar directorio.
	 */
	public void setBtnBuscarDirectorio(JButton btnBuscarDirectorio) {
		this.btnBuscarDirectorio = btnBuscarDirectorio;
	}

	/**
	 * Retorna el botón para salir.
	 * @return El botón para salir.
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Establece el botón para salir.
	 * @param btnSalir El botón para salir.
	 */
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}



	/**
	 * Constructor de la clase WCatalogo.
	 */
	public WCatalogo() {
		iniciar();
	}
	
	/**
	 * Inicializa la interfaz de la ventana.
	 */
	public void iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBusqueda = new JLabel("Busque el directorio de imágenes:");
		lblBusqueda.setForeground(new Color(255, 255, 255));
		lblBusqueda.setFont(new Font("Roboto", Font.BOLD, 30));
		lblBusqueda.setBounds(10, 25, 515, 43);
		contentPane.add(lblBusqueda);
		
		//Creacion Botones
		btnBuscarDirectorio = new JButton("BUSCAR DIRECTORIO");
		btnBuscarDirectorio.setFont(new Font("Roboto", Font.BOLD, 16));
		btnBuscarDirectorio.setBounds(554, 25, 237, 43);
		contentPane.add(btnBuscarDirectorio);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSalir.setBounds(829, 25, 118, 43);
		contentPane.add(btnSalir);

		//ScrollPane
        scrollPane = new JScrollPane();	
        panelImagenesOprimibles = new JPanel();
	       
	}
	
	/**
	 * Muestra un aviso para confirmar el cierre de la ventana.
	 * @return La opción seleccionada por el usuario (Sí o No).
	 */
	public int avisoCerrarVentana() {
		int val= JOptionPane.showConfirmDialog(null,"¿Está seguro que desea terminar el programa?", "Avertencia", JOptionPane.YES_NO_OPTION);
		return val;
	}
	
	/**
	 * Muestra un aviso con el mensaje proporcionado.
	 * @param mensaje El mensaje a mostrar.
	 */
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	//Método para imprimir en consola
	
	/**
	 * Imprime un mensaje en la consola.
	 * @param mensaje El mensaje a imprimir.
	 */
	public void enConsola(Object mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Ubica la imagen en el botón correspondiente.
	 * @param imagen La ruta de la imagen.
	 * @param boton El botón en el que se colocará la imagen.
	 */
	public void imagenEnBoton(String imagen, JButton boton) {
			ImageIcon img_foto=new ImageIcon(imagen);
			Image imgIns=img_foto.getImage();
			Image newImg =imgIns.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon finalImage=new ImageIcon(newImg);
			boton.setIcon(finalImage);
			panelImagenesOprimibles.add(boton);
		}
}

