package vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;

public class WCatalogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnBuscarDirectorio;
	private JButton btnSalir;
	
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

	private JLabel lblBusqueda;
	private JScrollPane scrollPane;
	private JPanel panelImagenesOprimibles;


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
		
		btnBuscarDirectorio = new JButton("BUSCAR DIRECTORIO");
		btnBuscarDirectorio.setFont(new Font("Roboto", Font.BOLD, 16));
		btnBuscarDirectorio.setBounds(554, 25, 237, 43);
		contentPane.add(btnBuscarDirectorio);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSalir.setBounds(829, 25, 118, 43);
		contentPane.add(btnSalir);
		
		//Panel que va a contener los botones de las respectivas imagenes por si se oprimen.
		panelImagenesOprimibles = new JPanel();
		panelImagenesOprimibles.setBackground(new Color(0, 0, 0));
        panelImagenesOprimibles.setLayout(new FlowLayout());
        
      /*  for (int i = 0; i < 100; i++)
        	{
            panelImagenesOprimibles.add(new JButton("Boton " + i));
        }
        */
        
        scrollPane = new JScrollPane(panelImagenesOprimibles);		
		scrollPane.setBounds(20, 79, 927, 433);
		
		contentPane.add(scrollPane);

	}
	
	public int avisoCerrarVentana() {
		int val= JOptionPane.showConfirmDialog(null,"¿Está seguro que desea terminar el programa?", "Avertencia", JOptionPane.YES_NO_OPTION);
		return val;
	}
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public void enConsola(String mensaje) {
		System.out.println(mensaje);
	}
}
