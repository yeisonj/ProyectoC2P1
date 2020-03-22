package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelView extends JPanel{

	public JLabel fondo = new JLabel();
	public ImageIcon imagenfondoelecciones = new ImageIcon("Resources/elecciones2020.png");
	public ImageIcon imagenfondociudadano = new ImageIcon("Resources/ciudadanos.png");
	public ImageIcon imagenfondoestadisticas = new ImageIcon("Resources/estadisticas.png");
	public ImageIcon imagenfondopvotacion = new ImageIcon("Resources/pvotacion.png");
	public JButton bPuestovotacion = new JButton();
	public JButton bCiudadanos = new JButton();
	public JButton bEstadisticas = new JButton();
	
	
	public PanelView() {
				
		setBounds(0,0,800,640);
		setLayout(null);
		setVisible(true);
		inicializarComponentes();
		
	}
	
	public void inicializarComponentes()
	{
				
		bCiudadanos.setBounds(91,347,235,50);
		bCiudadanos.setVisible(true);
		bCiudadanos.setIcon(imagenfondociudadano);
		add(bCiudadanos);
				
		bEstadisticas.setBounds(89,422,235,50);
		bEstadisticas.setIcon(imagenfondoestadisticas);
		bEstadisticas.setVisible(true);
		add(bEstadisticas);
		
		bPuestovotacion.setBounds(90,490,235,80);
		bPuestovotacion.setIcon(imagenfondopvotacion);
		bPuestovotacion.setVisible(true);
		add(bPuestovotacion);
		
		fondo.setBounds(0,0,800,600);
		fondo.setIcon(imagenfondoelecciones);
		fondo.setLayout(null);
		fondo.setVisible(true);
		add(fondo);
	}
	
}
