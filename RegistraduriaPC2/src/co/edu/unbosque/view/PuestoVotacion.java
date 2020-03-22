package co.edu.unbosque.view;

import javax.swing.JFrame;

public class PuestoVotacion extends JFrame{

	public PanelPuestoVotacion pPuestoVotacion = new PanelPuestoVotacion();
	public PuestoVotacion() {
		//PROPIEDADES DE LA VENTANA
		setSize(800, 640);
		setTitle("PUESTOS DE VOTACION");
		setLayout(null);
		setLocationRelativeTo(null);// CENTRAR LA VENTANA EN LA PANTALLA
		setResizable(false);// IMPIDE QUE EL USUARIO MODIFIQUE EL TAMAÑO DE LA VENTANA
		setVisible(false);
		add(pPuestoVotacion);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//DISPOSE_ON_CLOSE se usa para que al cerrar la ventana no se cierre el programa
		
	}
}
