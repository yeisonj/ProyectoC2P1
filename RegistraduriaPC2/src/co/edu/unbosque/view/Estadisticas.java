package co.edu.unbosque.view;

import javax.swing.JFrame;

public class Estadisticas extends JFrame {

	public Graficas graficas=new Graficas();
	public PanelEstadisticas pEstadisticas = new PanelEstadisticas();
	
	public Estadisticas() {
		//PROPIEDADES DE LA VENTANA
				setSize(800, 640);
				setTitle("ESTADISTICAS");
				setLayout(null);
				setLocationRelativeTo(null);// CENTRAR LA VENTANA EN LA PANTALLA
				setResizable(false);// IMPIDE QUE EL USUARIO MODIFIQUE EL TAMAÑO DE LA VENTANA
				setVisible(false);
				add(pEstadisticas);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);//DISPOSE_ON_CLOSE se usa para que al cerrar la ventana no se cierre el programa
				
	}
}
