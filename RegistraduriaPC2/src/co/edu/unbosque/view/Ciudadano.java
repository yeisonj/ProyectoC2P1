package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ciudadano extends JFrame{
	
	
	private ImageIcon imagenes;
	private JLabel fondo;
	private JButton agregarCiudadano;
	private JButton modificarCiudadano;
	private JButton eliminarCiudadano;
	private JButton mostrarInformacionCiudadano;

	public Ciudadano()
	{
		setSize(800, 640);
		setTitle("CIUDADANOS");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		inicializarComponentes();
		
	}
	
	public void inicializarComponentes()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenes = new ImageIcon("Resources/fondociudadanos.png");
		fondo.setLayout(null);
		fondo.setIcon(imagenes);
		
		agregarCiudadano = new JButton();
		agregarCiudadano.setBounds(75,147,235,80);
		imagenes = new ImageIcon("Resources/botonagregarciudadano.png");
		agregarCiudadano.setIcon(imagenes);
		agregarCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		modificarCiudadano = new JButton();
		modificarCiudadano.setBounds(75,260,235,80);
		imagenes = new ImageIcon("Resources/botonmodificarciudadano.png");
		modificarCiudadano.setIcon(imagenes);
		modificarCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		eliminarCiudadano = new JButton();
		eliminarCiudadano.setBounds(75,375,235,80);
		imagenes = new ImageIcon("Resources/botoneliminarciudadano.png");
		eliminarCiudadano.setIcon(imagenes);
		eliminarCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		mostrarInformacionCiudadano = new JButton();
		mostrarInformacionCiudadano.setBounds(75,492,235,80);
		imagenes = new ImageIcon("Resources/botoninformacionciudadano.png");
		mostrarInformacionCiudadano.setIcon(imagenes);
		mostrarInformacionCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		add(fondo);
		fondo.add(agregarCiudadano);
		fondo.add(modificarCiudadano);
		fondo.add(eliminarCiudadano);
		fondo.add(mostrarInformacionCiudadano);
	}

	public JButton getAgregarCiudadano() {
		return agregarCiudadano;
	}

	public void setAgregarCiudadano(JButton agregarCiudadano) {
		this.agregarCiudadano = agregarCiudadano;
	}

	public JButton getModificarCiudadano() {
		return modificarCiudadano;
	}

	public void setModificarCiudadano(JButton modificarCiudadano) {
		this.modificarCiudadano = modificarCiudadano;
	}

	public JButton getEliminarCiudadano() {
		return eliminarCiudadano;
	}

	public void setEliminarCiudadano(JButton eliminarCiudadano) {
		this.eliminarCiudadano = eliminarCiudadano;
	}

	public JButton getMostrarInformacionCiudadano() {
		return mostrarInformacionCiudadano;
	}

	public void setMostrarInformacionCiudadano(JButton mostrarInformacionCiudadano) {
		this.mostrarInformacionCiudadano = mostrarInformacionCiudadano;
	}
	
	
	
}
