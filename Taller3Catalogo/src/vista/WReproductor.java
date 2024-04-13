package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Gestor;

import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;

public class WReproductor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JProgressBar barra;
	private JPanel panelBotonFoto;
	private JButton btnDetener;
	private JButton btnContinuar;
	private JButton btnSalir;
	private JTextField fieldNumeroImagen;
	private JLabel lblSlash;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WReproductor frame = new WReproductor();
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
	public WReproductor() {
		iniciar();
	}
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public void enConsola(String mensaje) {
		System.out.println(mensaje);
	}
	public void iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBotonFoto = new JPanel();
		panelBotonFoto.setBounds(16, 100,600, 600);
		contentPane.add(panelBotonFoto);
		
		btnDetener = new JButton("DETENER");
		btnDetener.setFont(new Font("Roboto", Font.BOLD, 17));
		btnDetener.setBounds(0, 710, 260, 50);
		contentPane.add(btnDetener);
		
		btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setFont(new Font("Roboto", Font.BOLD, 17));
		btnContinuar.setBounds(260, 710, 260, 50);
		contentPane.add(btnContinuar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 17));
		btnSalir.setBounds(520, 710, 115, 50);
		contentPane.add(btnSalir);
		
		barra = new JProgressBar();
		barra.setForeground(new Color(0, 0, 0));
		barra.setBounds(16, 69, 600, 20);
		barra.setStringPainted(true);
		contentPane.add(barra);
		
		fieldNumeroImagen = new JTextField();
		fieldNumeroImagen.setBackground(new Color(255, 255, 255));
		fieldNumeroImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		fieldNumeroImagen.setFont(new Font("Roboto", Font.PLAIN, 15));
		fieldNumeroImagen.setBounds(485, 45, 60, 20);
		fieldNumeroImagen.setEditable(false);
		contentPane.add(fieldNumeroImagen);
		
		JLabel lblNumeroImagenes = new JLabel("");
		lblNumeroImagenes.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNumeroImagenes.setForeground(new Color(0, 0, 0));
		lblNumeroImagenes.setBounds(556, 45, 60, 20);
		contentPane.add(lblNumeroImagenes);
		
		lblSlash = new JLabel("/");
		lblSlash.setForeground(new Color(0, 0, 0));
		lblSlash.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSlash.setBounds(546, 45, 10, 20);
		contentPane.add(lblSlash);
		
		
		
	}
}
