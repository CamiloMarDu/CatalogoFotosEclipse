package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 * La clase WReproductor representa la ventana del reproductor de imágenes.
 */
public class WReproductor extends JFrame {

	private static final long serialVersionUID = 1L;
	   /** El panel principal de la interfaz. */
    private JPanel contentPane;

    /** La barra de progreso para mostrar el avance de la reproducción. */
    private JProgressBar barra;

    /** El panel que contiene la imagen reproducida. */
    private JPanel panelImagen;

    /** Botón para detener la reproducción. */
    private JButton btnDetener;

    /** Botón para continuar la reproducción. */
    private JButton btnContinuar;

    /** Botón para salir del reproductor. */
    private JButton btnSalir;

    /** Campo de texto para mostrar el número de la imagen actual. */
    private JTextField fieldNumeroImagen;

    /** Etiqueta que muestra el caracter "/" para separar el número actual del total de imágenes. */
    private JLabel lblSlash;

    /** Etiqueta que muestra la imagen reproducida. */
    private JLabel lblImagenReproducida;

    /** Etiqueta que muestra el número total de imágenes. */
    private JLabel lblNumeroImagenes;

	
	/**
	 * Create the frame.
	 */
	public WReproductor() {
		iniciar();
	}
	
	/**
	 * Inicializa la interfaz de la ventana del reproductor de imágenes.
	 */
	public void iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelImagen = new JPanel();
		panelImagen.setBounds(16, 100, 600, 600);
		contentPane.add(panelImagen);
		panelImagen.setLayout(null);
		
		lblImagenReproducida = new JLabel("");
		lblImagenReproducida.setBounds(0, 0, 600, 600);
		panelImagen.add(lblImagenReproducida);
		
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
		
		lblNumeroImagenes = new JLabel("");
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
	
	/**
	 * Muestra un aviso con el mensaje proporcionado.
	 * @param mensaje El mensaje a mostrar.
	 */
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	 * Imprime un mensaje en la consola.
	 * @param mensaje El mensaje a imprimir.
	 */
	public void enConsola(Object mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * Coloca la imagen en el panel de reproducción.
	 * @param imagen La ruta de la imagen a mostrar.
	 */
	public void imagenEnLabel(String imagen) {
		ImageIcon img_foto = new ImageIcon(imagen);
		Image imgIns = img_foto.getImage();
		Image newImg = imgIns.getScaledInstance(lblImagenReproducida.getWidth(), lblImagenReproducida.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon finalImage = new ImageIcon(newImg);
		lblImagenReproducida.setIcon(finalImage);
	}
	
	/**
	 * Establece el valor máximo de la barra de progreso.
	 * @param max El valor máximo de la barra de progreso.
	 */
	public void elegirMaximo(int max) {
		barra.setMaximum(max);
		lblNumeroImagenes.setText(String.valueOf(max));
	}
	
	/**
	 * Establece el valor actual de la barra de progreso.
	 * @param value El valor actual de la barra de progreso.
	 */
	public void porcentajeActual(int value) {
		barra.setValue(value);
		fieldNumeroImagen.setText(String.valueOf(value));
	}
	
	/**
	 * Retorna el botón de detener.
	 * @return El botón de detener.
	 */
	public JButton getBtnDetener() {
		return btnDetener;
	}
	
	/**
	 * Establece el botón de detener.
	 * @param btnDetener El botón de detener.
	 */
	public void setBtnDetener(JButton btnDetener) {
		this.btnDetener = btnDetener;
	}
	
	/**
	 * Retorna el botón de continuar.
	 * @return El botón de continuar.
	 */
	public JButton getBtnContinuar() {
		return btnContinuar;
	}
	
	/**
	 * Establece el botón de continuar.
	 * @param btnContinuar El botón de continuar.
	 */
	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}
	
	/**
	 * Retorna el botón de salir.
	 * @return El botón de salir.
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	/**
	 * Establece el botón de salir.
	 * @param btnSalir El botón de salir.
	 */
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
}
