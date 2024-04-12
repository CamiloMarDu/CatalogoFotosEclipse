package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WCatalogo frame = new WCatalogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 79, 937, 433);
		contentPane.add(panel);
		
		lblBusqueda = new JLabel("Busque el directorio de imágenes:");
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
	}
	
	public int avisoCerrarVentana() {
		int val= JOptionPane.showConfirmDialog(null,"¿Está seguro que desea terminar el programa?", "Avertencia", JOptionPane.YES_NO_OPTION);
		return val;
	}
}
