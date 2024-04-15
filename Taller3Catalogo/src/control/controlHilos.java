package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.SwingUtilities;

public class controlHilos extends Thread {
	private volatile boolean detenido = false; // Variable para controlar el estado del hilo
    private final Object lock = new Object(); // Objeto de bloqueo para la sincronización
    int tamaño;
    int posicionI; 
    List<File> imagen;
	private GestorVisor gestorVisor;
 
    public controlHilos(GestorVisor gestorVisor, int posicion, int tamaño, List<File> imagen) {
        this.gestorVisor = gestorVisor; // Asignar la referencia de GestorVisor
     
    }

   

    public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public int getPosicionI() {
		return posicionI;
	}

	public void setPosicionI(int posicionI) {
		this.posicionI = posicionI;
	}

	public List<File> getImagen() {
		return imagen;
	}

	public void setImagen(List<File> imagen) {
		this.imagen = imagen;
	}

	public void detenerHilo() {
        detenido = true;
     
    }

    public void reanudarHilo() {
        synchronized (lock) {
            detenido = false;
            lock.notify(); // Notificar al hilo para que continúe
        }
    }
  
    public void run() {
        gestorVisor.visor.elegirMaximo(tamaño);
        gestorVisor.visor.imagenEnLabel(imagen.get(posicionI).getPath());
     
        gestorVisor.visor.porcentajeActual(  posicionI + 1);
       
        try {
            Thread.sleep(1); // Esperar el tiempo de espera especificado
        } catch (InterruptedException e) {
            this.gestorVisor.visor.enConsola(e);
        }
        
        int currentIndex = 0;
        int posinicial=posicionI;
        while (!detenido) {
            final int index = currentIndex; // Variable final para usar en el hilo
            final int index2=posinicial;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    gestorVisor.visor.porcentajeActual( index + 1+index2);
                    gestorVisor.visor.imagenEnLabel(imagen.get(index+index2 ).getPath());
                    gestorVisor.visor.enConsola(imagen.get(index +index2).getPath());
                }
            });
            try {
                Thread.sleep(5000); // Esperar el tiempo de espera especificado
            } catch (InterruptedException e) {
            	this.gestorVisor.visor.enConsola(e);
            }
            // Incrementar currentIndex y verificar si ha alcanzado el máximo
            currentIndex++;
            if (currentIndex == tamaño -posinicial) {
                currentIndex = 0;
                posinicial=0;// Reiniciar a 0 si alcanza la posición máxima
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
        }
    }
}

