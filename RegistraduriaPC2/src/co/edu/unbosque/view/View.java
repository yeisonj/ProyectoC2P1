package co.edu.unbosque.view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {
	
	private PuestoVotacion pPuestoVotacion;
	private Estadisticas pEstadisticas;
	private Graficas pGraficas;
	private Principal pPrincipal;
	
	public View()
	{
		pPrincipal = new Principal();
		pPrincipal.setLayout(null);
		pPrincipal.setSize(800, 640);
		pPrincipal.setTitle("PRINCIPAL");
		pPrincipal.setLayout(null);
		pPrincipal.setLocationRelativeTo(null);
		pPrincipal.setResizable(false);
		pPrincipal.setVisible(true);
		pPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		pPuestoVotacion = new PuestoVotacion();
		pPuestoVotacion.setLayout(null);
		
		pEstadisticas = new Estadisticas();
		pEstadisticas.setLayout(null);
		
		pGraficas = new Graficas();
		pGraficas.setLayout(null);
		
		cambiarIcono();
		
		
	}
	
	
	public void cambiarIcono()
	{
		ImageIcon icono = new ImageIcon("Resources/icono.png");
		Image image = icono.getImage();
		setIconImage(image);
		pPrincipal.setIconImage(image);
		pEstadisticas.setIconImage(image);
		pGraficas.setIconImage(image);
		pPuestoVotacion.setIconImage(image);
	}


	public PuestoVotacion getpPuestoVotacion() {
		return pPuestoVotacion;
	}


	public void setpPuestoVotacion(PuestoVotacion pPuestoVotacion) {
		this.pPuestoVotacion = pPuestoVotacion;
	}


	public Estadisticas getpEstadisticas() {
		return pEstadisticas;
	}


	public void setpEstadisticas(Estadisticas pEstadisticas) {
		this.pEstadisticas = pEstadisticas;
	}


	public Graficas getpGraficas() {
		return pGraficas;
	}


	public void setpGraficas(Graficas pGraficas) {
		this.pGraficas = pGraficas;
	}


	public Principal getpPrincipal() {
		return pPrincipal;
	}


	public void setpPrincipal(Principal pPrincipal) {
		this.pPrincipal = pPrincipal;
	}

	
	
	
}
