package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class controlHilos extends Thread {
	private volatile boolean detenido = false; // Variable para controlar el estado del hilo
    private final Object lock = new Object(); // Objeto de bloqueo para la sincronización
    
 
  

   

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
    	
    	
    	
    }
    public void run(int tamaño,int posicionI, List<File> imagen) {
        for (int i = 0; i < (tamaño-posicionI); i++) {
            System.out.println(imagen.get(posicionI+i));
            try {
                Thread.sleep(50000); // Esperar el tiempo de espera especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Verificar si el hilo debe ser detenido
            synchronized (lock) {
                while (detenido) {
                    try {
                        lock.wait(); // Esperar hasta que se reanude el hilo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    } 
}
