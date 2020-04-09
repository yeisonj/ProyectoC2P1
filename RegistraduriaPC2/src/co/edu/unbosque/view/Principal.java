package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <h1>Modela una clase extendida de JFrame Principal </h1>
* Este frame se encarga de mostrar el primer frame que se muestra en el programa
* @version 1.0
* @author Diego Torres | Universidad El Bosque
 */

public class Principal extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	private JButton bPuestoVotacion;
	private JButton bCiudadanos;
	private JButton bEstadisticas;
	
	/**Constructor de la clase Principal
	 */
	
	public Principal()
	{
		inicializarComponentes();
	}
	
	/**Este método se encarga de instanciar los componentes principales de la clase Principal
	 * 
	 */
	public void inicializarComponentes()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenes = new ImageIcon("Resources/elecciones2020.png");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
	
		bCiudadanos = new JButton();
		bCiudadanos.setBounds(91,347,235,50);
		imagenes = new ImageIcon("Resources/ciudadanos.png");
		bCiudadanos.setIcon(imagenes);
		bCiudadanos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		bEstadisticas = new JButton();
		bEstadisticas.setBounds(89,422,235,50);
		imagenes = new ImageIcon("Resources/estadisticas.png");
		bEstadisticas.setIcon(imagenes);
		bEstadisticas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	
		bPuestoVotacion = new JButton();
		bPuestoVotacion.setBounds(90,490,235,80);
		imagenes = new ImageIcon("Resources/pvotacion.png");
		bPuestoVotacion.setIcon(imagenes);
		bPuestoVotacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		getContentPane().add(fondo);
		fondo.add(bCiudadanos);
		fondo.add(bEstadisticas);
		fondo.add(bPuestoVotacion);
		
	}

	public JButton getbPuestoVotacion() {
		return bPuestoVotacion;
	}

	public JButton getbCiudadanos() {
		return bCiudadanos;
	}

	public JButton getbEstadisticas() {
		return bEstadisticas;
	}
	
	
}
