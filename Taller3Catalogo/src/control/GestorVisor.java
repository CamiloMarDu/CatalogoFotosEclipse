package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import vista.WReproductor;

/**
 * Clase que gestiona la interfaz del visor de imágenes y controla el hilo asociado.
 */
public class GestorVisor implements ActionListener {
    controlHilos ha;
    WReproductor visor;
    
    /**
     * Constructor de la clase GestorVisor.
     * @param posicion La posición de la imagen seleccionada.
     * @param tamano El tamano total de la lista de imágenes.
     * @param imagen La lista de imágenes.
     */
    public GestorVisor(int posicion, int tamano, List<File> imagen) {
        visor = new WReproductor();
        ha = new controlHilos(this, posicion, tamano, imagen);
        ha.setImagen(imagen);
        ha.setPosicionI(imagen.size() - posicion);
        ha.setTamano(imagen.size());
        ha.start();
        
        visor.aviso("\nId Hilo a ejecutar:" + ha.getId() + "\nimagen elegida" + imagen.get(imagen.size() - posicion).getPath());
        visor.setVisible(true);
        visor.setResizable(false);
        visor.setLocationRelativeTo(null);
        visor.setTitle("Visor de hilo No." + ha.getId());
        
        // SECCION DE ACTION LISTENERS DE LOS BOTONES
        visor.getBtnDetener().addActionListener(this);
        visor.getBtnDetener().setActionCommand("detener");
        
        visor.getBtnContinuar().addActionListener(this);
        visor.getBtnContinuar().setActionCommand("continuar");
        
        visor.getBtnSalir().addActionListener(this);
        visor.getBtnSalir().setActionCommand("salir");
        
        visor.getBtnContinuar().setEnabled(false);
    }

    /**
     * Método para manejar los eventos de los botones del visor.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ("detener"):
                ha.detenerHilo();
                visor.getBtnContinuar().setEnabled(true);
                visor.getBtnDetener().setEnabled(false);
                visor.aviso("las imagenes se han detenido");
                break;
            case ("continuar"):
                ha.reanudarHilo();
                visor.getBtnContinuar().setEnabled(false);
                visor.getBtnDetener().setEnabled(true);
                visor.aviso("La ejecución del hilo No: " + ha.getId() + " esta viva? " + ha.estaVivo());
                visor.aviso("sea continuado");
                break;
            case ("salir"):
                visor.aviso("La ejecución del hilo No: " + ha.getId() + " termina");
                visor.dispose();
                ha.matar();
                break;
        }
    }
}

