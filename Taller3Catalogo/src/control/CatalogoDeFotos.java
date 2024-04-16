package control;

import java.awt.EventQueue;

/**
 * Clase principal que inicia la aplicación del catálogo de fotos.
 */
public class CatalogoDeFotos {
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Gestor(); // Inicia la aplicación llamando al constructor de Gestor
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

