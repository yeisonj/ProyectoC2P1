package co.edu.unbosque.view;

import javax.swing.JFrame;

public class Graficas extends JFrame{

	public PanelGraficas pGraficas = new PanelGraficas();
	public Graficas() {
		//PROPIEDADES DE LA VENTANA
		setSize(800, 640);
		setTitle("GRAFICAS");
		setLayout(null);
		setLocationRelativeTo(null);// CENTRAR LA VENTANA EN LA PANTALLA
		setResizable(false);// IMPIDE QUE EL USUARIO MODIFIQUE EL TAMAÑO DE LA VENTANA
		setVisible(false);
		add(pGraficas);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//DISPOSE_ON_CLOSE se usa para que al cerrar la ventana no se cierre el programa
		
	}
	
}
