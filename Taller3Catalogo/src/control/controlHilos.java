package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * Clase que controla el hilo de ejecución para la reproducción de imágenes.
 */
public class controlHilos extends Thread {
    private volatile boolean detenido = false; // Variable para controlar el estado del hilo
    private final Object lock = new Object(); // Objeto de bloqueo para la sincronización
    private int tamano;
    private int posicionI;
    private boolean matar = false;
    private List<File> imagen;
    private GestorVisor gestorVisor;

    /**
     * Constructor de la clase controlHilos.
     * @param gestorVisor El objeto GestorVisor asociado al controlHilos.
     * @param posicion La posición inicial de la imagen.
     * @param tamano El tamaño total de la lista de imágenes.
     * @param imagen La lista de imágenes a reproducir.
     */
    public controlHilos(GestorVisor gestorVisor, int posicion, int tamano, List<File> imagen) {
        this.gestorVisor = gestorVisor;
    }

    /**
     * Obtiene el tamaño total de la lista de imágenes.
     * @return El tamaño total de la lista de imágenes.
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Establece el tamano total de la lista de imágenes.
     * @param tamano El tamano total de la lista de imágenes.
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * Obtiene la posición actual de la imagen en reproducción.
     * @return La posición actual de la imagen.
     */
    public int getPosicionI() {
        return posicionI;
    }

    /**
     * Establece la posición inicial de la imagen.
     * @param posicionI La posición inicial de la imagen.
     */
    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    /**
     * Obtiene la lista de imágenes a reproducir.
     * @return La lista de imágenes.
     */
    public List<File> getImagen() {
        return imagen;
    }

    /**
     * Establece la lista de imágenes a reproducir.
     * @param imagen La lista de imágenes.
     */
    public void setImagen(List<File> imagen) {
        this.imagen = imagen;
    }

    /**
     * Detiene la ejecución del hilo.
     */
    public void detenerHilo() {
        detenido = true;
    }

    /**
     * Reanuda la ejecución del hilo.
     */
    public void reanudarHilo() {
        synchronized (lock) {
            detenido = false;
            lock.notify(); // Notificar al hilo para que continúe
        }
    }

    /**
     * Interrumpe la ejecución del hilo.
     * @return true si se interrumpe el hilo, false en caso contrario.
     */
    public boolean matar() {
        matar = true; // Interrumpir el hilo
        return matar;
    }

    /**
     * Verifica si el hilo está vivo.
     * @return true si el hilo está vivo, false en caso contrario.
     */
    public boolean estaVivo() {
        return this.isAlive(); // Utiliza el método isAlive() de la clase Thread para verificar si el hilo está vivo
    }

    /**
     * Método principal del hilo de control.
     */
    public void run() {
        gestorVisor.visor.elegirMaximo(tamano);
        gestorVisor.visor.imagenEnLabel(imagen.get(posicionI).getPath());
     
        gestorVisor.visor.porcentajeActual(posicionI + 1);
       
        try {
            Thread.sleep(1); // Esperar el tiempo de espera especificado
        } catch (InterruptedException e) {
            this.gestorVisor.visor.enConsola(e);
        }
        
        int currentIndex = 0;
        int posinicial = posicionI;
        while (!detenido) {
            final int index = currentIndex; // Variable final para usar en el hilo
            final int index2 = posinicial;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    gestorVisor.visor.porcentajeActual(index + 1 + index2);
                    gestorVisor.visor.imagenEnLabel(imagen.get(index + index2).getPath());
                    gestorVisor.visor.enConsola(imagen.get(index + index2).getPath());
                }
            });
            try {
                Thread.sleep(5000); // Esperar el tiempo de espera especificado
            } catch (InterruptedException e) {
                this.gestorVisor.visor.enConsola(e);
            }
            // Incrementar currentIndex y verificar si ha alcanzado el máximo
            currentIndex++;
            if (currentIndex == tamano - posinicial) {
                currentIndex = 0;
                posinicial = 0; // Reiniciar a 0 si alcanza la posición máxima
            }
            // Verificar si el hilo debe ser detenido
            synchronized (lock) {
                while (detenido) {
                    try {
                        lock.wait(); // Esperar hasta que se reanude el hilo
                    } catch (InterruptedException e) {
                        this.gestorVisor.visor.enConsola(e);
                    }
                }
            }
            if (matar) {
                this.detenerHilo();
                this.interrupt();
                break;
            }
        }
    }
}
