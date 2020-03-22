package co.edu.unbosque.view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {
	
	private ImageIcon imagenfondo;
	private JButton puestovotacion;
	private JPanel principal;
	private JButton ciudadanos;
	private JButton estadisticas;
	private JLabel fondo;
	private PanelPuestoVotacion pPuestoVotacion;
	private PanelEstadisticas pEstadisticas;
	private PanelGraficas pGraficas;
	
	public View()
	{
		
		principal = new JPanel();
		principal.setBounds(0,0,800,600);
		principal.setLayout(null);
		principal.setVisible(true);
		
		
		pPuestoVotacion = new PanelPuestoVotacion();
		pPuestoVotacion.setBounds(0,0,800,600);
		pPuestoVotacion.setLayout(null);
		pPuestoVotacion.setVisible(false);
		
		pEstadisticas = new PanelEstadisticas();
		pEstadisticas.setBounds(0,0,800,600);
		pEstadisticas.setLayout(null);
		pEstadisticas.setVisible(false);
		
		pGraficas = new PanelGraficas();
		pGraficas.setBounds(0,0,800,600);
		pGraficas.setLayout(null);
		pGraficas.setVisible(false);
		
		panelDeControl();
		cambiarIcono();
		
		add(pPuestoVotacion);
		add(principal);
		add(pEstadisticas);
		add(pGraficas);
		
	}
	
	public void panelDeControl()
	{

		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenfondo = new ImageIcon("Resources/elecciones2020.png");
		fondo.setIcon(imagenfondo);
		fondo.setLayout(null);
	
		
		
		
		ciudadanos = new JButton();
		ciudadanos.setBounds(91,347,235,50);
		imagenfondo = new ImageIcon("Resources/ciudadanos.png");
		ciudadanos.setIcon(imagenfondo);

		
		estadisticas = new JButton();
		estadisticas.setBounds(89,422,235,50);
		imagenfondo = new ImageIcon("Resources/estadisticas.png");
		estadisticas.setIcon(imagenfondo);
	
		puestovotacion = new JButton();
		puestovotacion.setBounds(90,490,235,80);
		imagenfondo = new ImageIcon("Resources/pvotacion.png");
		puestovotacion.setIcon(imagenfondo);
		
		principal.add(fondo);
		fondo.add(ciudadanos);
		fondo.add(estadisticas);
		fondo.add(puestovotacion);
		
	}
	
	public void cambiarIcono()
	{
		ImageIcon icono = new ImageIcon("Resources/icono.png");
		Image image = icono.getImage();
		setIconImage(image);
	}

	public JButton getPuestovotacion() {
		return puestovotacion;
	}

	public void setPuestovotacion(JButton puestovotacion) {
		this.puestovotacion = puestovotacion;
	}

	public JPanel getPrincipal() {
		return principal;
	}

	public void setPrincipal(JPanel principal) {
		this.principal = principal;
	}

	public JButton getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(JButton ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public JButton getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(JButton estadisticas) {
		this.estadisticas = estadisticas;
	}

	public PanelPuestoVotacion getpPuestoVotacion() {
		return pPuestoVotacion;
	}

	public void setpPuestoVotacion(PanelPuestoVotacion pPuestoVotacion) {
		this.pPuestoVotacion = pPuestoVotacion;
	}

	public PanelEstadisticas getpEstadisticas() {
		return pEstadisticas;
	}

	public void setpEstadisticas(PanelEstadisticas pEstadisticas) {
		this.pEstadisticas = pEstadisticas;
	}

	public PanelGraficas getpGraficas() {
		return pGraficas;
	}

	public void setpGraficas(PanelGraficas pGraficas) {
		this.pGraficas = pGraficas;
	}
	
	
	
}
