package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.WReproductor;

public class GestorVisor implements ActionListener {
	controlHilos h;
	WReproductor visor;
	public GestorVisor() {
		h= new controlHilos();
        h.start();
        
        
        
		visor = new WReproductor();
    	visor.aviso("\nId Hilo a ejecutar:"+h.getId());
    	visor.setVisible(true);
    	visor.setResizable(false);
    	visor.setLocationRelativeTo(null);
    	visor.setTitle("Visor de hilo No."+ h.getId());
    	
        // SECCION DE ACTION LISTENERS DE LOS BOTONES
    	visor.getBtnDetener().addActionListener(this);
        visor.getBtnDetener().setActionCommand("detener");
        
        visor.getBtnContinuar().addActionListener(this);
        visor.getBtnContinuar().setActionCommand("continuar");
        
        visor.getBtnSalir().addActionListener(this);
        visor.getBtnSalir().setActionCommand("salir");
        
        visor.getBtnContinuar().setEnabled(false);
        
        visor.imagenEnLabel(null);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case ("detener"):

			h.detenerHilo();
			visor.getBtnContinuar().setEnabled(true);
			visor.getBtnDetener().setEnabled(false);
		
			visor.aviso(null);
			break;
		case ("continuar"):
			h.reanudarHilo();
			visor.getBtnContinuar().setEnabled(false);
			visor.getBtnDetener().setEnabled(true);
			
			visor.aviso(null);
			break;
		case ("salir"):
			visor.aviso("La ejecución del hilo No: "+h.getId()+" termina");
			visor.dispose();
			break;
		}
	}

}
