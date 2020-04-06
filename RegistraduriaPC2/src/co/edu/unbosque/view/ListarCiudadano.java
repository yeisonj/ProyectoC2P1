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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListarCiudadano extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	private JTextField cedula;
	
	
	private JComboBox<String> departamentos;
	private JComboBox<String> municipios;
	private JComboBox<String> puestoVotacion;
	private JComboBox<String> localizacion;
	
	private JButton validarCedula;
	private JButton validarinfogeneral;
	
	private JScrollPane scroll;
	
	private JTable infoCiudadano;
	private JTable infoGeneral;
	
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
		
		String[] cabezeraciudadano = {"CÉDULA","PRIMER APELLIDO","SEGUNDO APELLIDO","PRIMER NOMBRE","SEGUNDO NOMBRE",
				"FECHA DE NACIMIENTO","LUGAR DE NACIMIENTO","FECHA DE EXPEDICIÓN CÉDULA","LUGAR DE EXPEDICIÓN CÉDULA","GÉNERO","PUESTO DE VOTACIÓN ASIGNADO"};
		String[][] tablaciudadano = new String[1][11];
		
		
		
		infoCiudadano = new JTable(tablaciudadano,cabezeraciudadano);
		infoCiudadano.setBackground(Color.LIGHT_GRAY);
		infoCiudadano.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		infoCiudadano.getColumnModel().getColumn(0).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(1).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(2).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(3).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(4).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(5).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(6).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(7).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(8).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(9).setPreferredWidth(200);
		infoCiudadano.getColumnModel().getColumn(10).setPreferredWidth(500);
		
		infoCiudadano.setPreferredSize(new Dimension(2500,50));
		
		
		
		scroll = new JScrollPane();
		scroll.setBounds(40,190,720,60);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(infoCiudadano);
		scroll.getViewport().setView(infoCiudadano);
		
		
		localizacion = new JComboBox<String>();
		localizacion.setBounds(420,270,140,30);
		localizacion.addItem("PAIS");
		localizacion.addItem("DEPARTAMENTOS");
		localizacion.addItem("MUNICIPIOS");
		localizacion.addItem("PUESTOS DE VOTACIÓN");
		
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
		
		String[] cabezeraciudadanogeneral = {"CÉDULA","PRIMER APELLIDO","SEGUNDO APELLIDO","PRIMER NOMBRE","SEGUNDO NOMBRE",
				"FECHA DE NACIMIENTO","LUGAR DE NACIMIENTO","FECHA DE EXPEDICIÓN CÉDULA","LUGAR DE EXPEDICIÓN CÉDULA", "GÉNERO","PUESTO DE VOTACIÓN ASIGNADO"};
		String[][] tablaciudadanogeneral = new String[30][11];
		
		
		
		infoGeneral = new JTable(tablaciudadanogeneral,cabezeraciudadanogeneral);
		infoGeneral.setBackground(Color.LIGHT_GRAY);
		infoGeneral.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		infoGeneral.getColumnModel().getColumn(0).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(1).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(2).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(3).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(4).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(5).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(6).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(7).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(8).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(9).setPreferredWidth(200);
		infoGeneral.getColumnModel().getColumn(10).setPreferredWidth(500);
		
		infoCiudadano.setPreferredSize(new Dimension(2500,50));
		
		
		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBounds(40,370,720,200);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setViewportView(infoGeneral);
		scroll2.getViewport().setView(infoGeneral);
		
		
		
		getContentPane().add(fondo);
		fondo.add(cedula);
		fondo.add(departamentos);
		fondo.add(municipios);
		fondo.add(puestoVotacion);
		fondo.add(scroll);
		fondo.add(scroll2);
		fondo.add(validarCedula);
		fondo.add(validarinfogeneral);
		fondo.add(localizacion);
		
		
	}
	public void reestablecerValores()
	{
		cedula.setText("");
		departamentos.setSelectedItem("SELECCIONE");
		municipios.setSelectedItem("SELECCIONE");
		puestoVotacion.setSelectedItem("SELECCIONE PUESTO");
		
	}

	

	public JTextField getCedula() {
		return cedula;
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

	public JTable getInfoCiudadano() {
		return infoCiudadano;
	}

	public JTable getInfoGeneral() {
		return infoGeneral;
	}

	public JComboBox<String> getLocalizacion() {
		return localizacion;
	}

	
	
	
}
