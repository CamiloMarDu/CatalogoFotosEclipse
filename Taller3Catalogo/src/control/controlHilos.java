package control;

public class controlHilos extends Thread {
	private volatile boolean detenido = false; // Variable para controlar el estado del hilo
    private final Object lock = new Object(); // Objeto de bloqueo para la sincronización
    private int iteraciones;
  

    public controlHilos(int iteraciones) {
        this.iteraciones = iteraciones;
       
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
        for (int i = 1; i <= iteraciones; i++) {
            System.out.println("Iteración " + i);
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
