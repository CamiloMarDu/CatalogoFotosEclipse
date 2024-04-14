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

public class WCatalogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel lblBusqueda;
	private JButton btnBuscarDirectorio;
	private JButton btnSalir;
	
	private JScrollPane scrollPane;
	public JPanel panelImagenesOprimibles;
	
	//Getters y setters botones
	public JButton getBtnBuscarDirectorio() {
		return btnBuscarDirectorio;
	}

	public void setBtnBuscarDirectorio(JButton btnBuscarDirectorio) {
		this.btnBuscarDirectorio = btnBuscarDirectorio;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}



	/**
	 * Create the frame.
	 */
	public WCatalogo() {
		iniciar();
	}
	
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
		lblBusqueda.setFont(new Font("Roboto", Font.BOLD, 32));
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
	
	public int avisoCerrarVentana() {
		int val= JOptionPane.showConfirmDialog(null,"¿Está seguro que desea terminar el programa?", "Avertencia", JOptionPane.YES_NO_OPTION);
		return val;
	}
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public void enConsola(Object mensaje) {
		System.out.println(mensaje);
	}
	//Método para ubicar la imagen en el boton correspondiente, se usa una imagen de prueba que luego se cambiará
	public void imagenEnBoton(String imagen, JButton boton) {
			ImageIcon img_foto=new ImageIcon(imagen);
			Image imgIns=img_foto.getImage();
			Image newImg =imgIns.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon finalImage=new ImageIcon(newImg);
			boton.setIcon(finalImage);
			panelImagenesOprimibles.add(boton);
		}
	//Método para ubicar la imagen en el panel correspondiente, se usa una imagen de prueba que luego se cambiará
		public void imagenEnLabel(String imagen, JLabel label, JPanel panel) {
			ImageIcon img_foto=new ImageIcon(imagen);
			Image imgIns=img_foto.getImage();
			Image newImg =imgIns.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon finalImage=new ImageIcon(newImg);
			label.setIcon(finalImage);
			panel.add(label);
		}
		
	public void cicloBotones(int cant, List<File> imagen) {
		
		//ScrollPane
		scrollPane.setBounds(20, 79, 927, 433);
		
		contentPane.add(scrollPane);
		
		panelImagenesOprimibles.setBackground(Color.black);
		scrollPane.setViewportView(panelImagenesOprimibles);
		panelImagenesOprimibles.setLayout(null);
		
		for (int i = 0; i < cant; i++) {
	    	   JButton boton=new JButton();
	    	   int posFin=i*400;
	    	   boton.setBounds(posFin,5,400,400);
	    	   panelImagenesOprimibles.setPreferredSize(new Dimension(i*400,40));
	    	 
	    	   imagenEnBoton("C:\\Users\\juanc\\OneDrive\\Desktop\\fotos messi\\"+imagen.get(i).getName(), boton);
		}
	}
}
