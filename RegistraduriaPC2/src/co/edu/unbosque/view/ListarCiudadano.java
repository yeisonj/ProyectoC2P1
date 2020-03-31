package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListarCiudadano extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	private JTextField cedula;
	
	
	private JComboBox<String> departamentos;
	private JComboBox<String> municipios;
	private JComboBox<String> puestoVotacion;
	
	private JButton validarCedula;
	private JButton validarinfogeneral;
	
	private JScrollPane scroll;
	
	private JTextArea infoCiudadano;
	private JTextArea infogeneral;
	
	public ListarCiudadano()
	{
		setSize(800, 640);
		setTitle("INFORMACIÓN");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		inicializarComponentes();
		reestablecerValores();
		
		
	}
	
	public void inicializarComponentes()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenes = new ImageIcon("Resources/informacion.png");
		fondo.setLayout(null);
		fondo.setIcon(imagenes);
		
		
		cedula = new JTextField();
		cedula.setBounds(220,147,150,35);
		cedula.setFont(new Font("helvetica",Font.PLAIN,17));
		cedula.setHorizontalAlignment(JTextField.CENTER);
		
		validarCedula = new JButton();
		validarCedula.setBounds(442,145,160,35);
		imagenes = new ImageIcon("Resources/botonbuscar.png");
		validarCedula.setIcon(imagenes);
		validarCedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		infoCiudadano = new JTextArea();
		infoCiudadano.setEnabled(false);
		infoCiudadano.setBackground(Color.LIGHT_GRAY);
		infoCiudadano.setPreferredSize(new Dimension(800,50));
		
		
		scroll = new JScrollPane();
		scroll.setBounds(40,190,720,50);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(infoCiudadano);
		scroll.getViewport().setView(infoCiudadano);
		
		
		departamentos = new JComboBox<String>();
		departamentos.setBounds(55,320,140,35);
		departamentos.addItem("SELECCIONE");
		
		municipios = new JComboBox<String>();
		municipios.setBounds(215,320,140,35);
		municipios.addItem("SELECCIONE");
		
		puestoVotacion = new JComboBox<String>();
		puestoVotacion.setBounds(360,320,200,35);
		puestoVotacion.addItem("SELECCIONE PUESTO");
		
		validarinfogeneral = new JButton();
		validarinfogeneral.setBounds(573,318,160,35);
		imagenes = new ImageIcon("Resources/botonbuscar.png");
		validarinfogeneral.setIcon(imagenes);
		validarinfogeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		infogeneral = new JTextArea();
		infogeneral.setEnabled(false);
		infogeneral.setBackground(Color.LIGHT_GRAY);
		infogeneral.setPreferredSize(new Dimension(800,500));
		
		
		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBounds(40,370,720,200);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setViewportView(infogeneral);
		scroll2.getViewport().setView(infogeneral);
		
		
		
		getContentPane().add(fondo);
		fondo.add(cedula);
		fondo.add(departamentos);
		fondo.add(municipios);
		fondo.add(puestoVotacion);
		fondo.add(scroll);
		fondo.add(scroll2);
		fondo.add(validarCedula);
		fondo.add(validarinfogeneral);
		
		
	}
	public void reestablecerValores()
	{
		cedula.setText("");
		departamentos.setSelectedItem("SELECCIONE");
		municipios.setSelectedItem("SELECCIONE");
		puestoVotacion.setSelectedItem("SELECCIONE PUESTO");
		infoCiudadano.setText("");
		infogeneral.setText("");
	}

	public String getCedula() {
		return cedula.getText();
	}

	public JComboBox<String> getDepartamentos() {
		return departamentos;
	}

	public JComboBox<String> getMunicipios() {
		return municipios;
	}

	public JComboBox<String> getPuestoVotacion() {
		return puestoVotacion;
	}

	public JButton getValidarCedula() {
		return validarCedula;
	}

	public JButton getValidarinfogeneral() {
		return validarinfogeneral;
	}

	public String getInfoCiudadano() {
		return infoCiudadano.getText();
	}

	public String getInfogeneral() {
		return infogeneral.getText();
	}
	
}
