package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	private JButton bPuestoVotacion;
	private JButton bCiudadanos;
	private JButton bEstadisticas;
	
	
	
	public Principal()
	{
		inicializarComponentes();
	}
	
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

		
		bEstadisticas = new JButton();
		bEstadisticas.setBounds(89,422,235,50);
		imagenes = new ImageIcon("Resources/estadisticas.png");
		bEstadisticas.setIcon(imagenes);
	
		bPuestoVotacion = new JButton();
		bPuestoVotacion.setBounds(90,490,235,80);
		imagenes = new ImageIcon("Resources/pvotacion.png");
		bPuestoVotacion.setIcon(imagenes);
		
		add(fondo);
		fondo.add(bCiudadanos);
		fondo.add(bEstadisticas);
		fondo.add(bPuestoVotacion);
		
	}

	public JButton getbPuestoVotacion() {
		return bPuestoVotacion;
	}

	public void setbPuestoVotacion(JButton bPuestoVotacion) {
		this.bPuestoVotacion = bPuestoVotacion;
	}

	public JButton getbCiudadanos() {
		return bCiudadanos;
	}

	public void setbCiudadanos(JButton bCiudadanos) {
		this.bCiudadanos = bCiudadanos;
	}

	public JButton getbEstadisticas() {
		return bEstadisticas;
	}

	public void setbEstadisticas(JButton bEstadisticas) {
		this.bEstadisticas = bEstadisticas;
	}
	
	
	
}
