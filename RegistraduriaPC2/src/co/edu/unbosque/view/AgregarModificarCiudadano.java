package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

public class AgregarModificarCiudadano extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	
	private JTextField cedula;
	private JTextField fexpedicion;
	private JTextField lexpedicion;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField nombre1;
	private JTextField nombre2;
	private JTextField fNacimiento;
	private JTextField lNacimiento;
	private JTextField sexo;
	
	private JComboBox<String> departamentos;
	private JComboBox<String> municipios;
	private JComboBox<String> puestoVotacion;
	
	private JButton agregarCiudadano;
	private JButton modificarCiudadano;
	
	private PlaceHolder holder;
	
	
	public AgregarModificarCiudadano()
	{
		setSize(800, 640);
		setTitle("CIUDADANOS");
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
		imagenes = new ImageIcon("Resources/agregarciudadano.png");
		fondo.setLayout(null);
		fondo.setIcon(imagenes);
		
		cedula = new JTextField();
		cedula.setBounds(115,215,130,35);
		cedula.setFont(new Font("helvetica",Font.PLAIN,17));
		cedula.setHorizontalAlignment(JTextField.CENTER);
		holder = new PlaceHolder(cedula, new Color(189, 189, 189), Color.BLACK,"Introduzca Cédula", false, "helvetica", 15);
		holder.setCursiva(true);
		
		fexpedicion = new JTextField();
		fexpedicion.setBounds(295,215,140,35);
		holder = new PlaceHolder(fexpedicion, new Color(189, 189, 189), Color.BLACK,"mm/dd/yyyy", true, "helvetica", 15);
		holder.setCursiva(true);
		fexpedicion.setFont(new Font("helvetica",Font.PLAIN,17));
		fexpedicion.setHorizontalAlignment(JTextField.CENTER);
		
		
		lexpedicion = new JTextField();
		lexpedicion.setBounds(493,215,170,35);
		lexpedicion.setFont(new Font("helvetica",Font.PLAIN,17));
		lexpedicion.setHorizontalAlignment(JTextField.CENTER);
		
		apellido1 = new JTextField();
		apellido1.setBounds(85,295,125,35);
		apellido1.setFont(new Font("helvetica",Font.PLAIN,17));
		apellido1.setHorizontalAlignment(JTextField.CENTER);
		
		apellido2 = new JTextField();
		apellido2.setBounds(245,295,142,35);
		apellido2.setFont(new Font("helvetica",Font.PLAIN,17));
		apellido2.setHorizontalAlignment(JTextField.CENTER);
		
		nombre1 = new JTextField();
		nombre1.setBounds(423,295,125,35);
		nombre1.setFont(new Font("helvetica",Font.PLAIN,17));
		nombre1.setHorizontalAlignment(JTextField.CENTER);
		
		nombre2 = new JTextField();
		nombre2.setBounds(580,295,145,35);
		nombre2.setFont(new Font("helvetica",Font.PLAIN,17));
		nombre2.setHorizontalAlignment(JTextField.CENTER);
		
		fNacimiento = new JTextField();
		fNacimiento.setBounds(150,365,140,35);
		fNacimiento.setFont(new Font("helvetica",Font.PLAIN,17));
		fNacimiento.setHorizontalAlignment(JTextField.CENTER);
		
		lNacimiento = new JTextField();
		lNacimiento.setBounds(327,365,170,35);
		lNacimiento.setFont(new Font("helvetica",Font.PLAIN,17));
		lNacimiento.setHorizontalAlignment(JTextField.CENTER);
		
		sexo = new JTextField();
		sexo.setBounds(550,365,120,35);
		sexo.setFont(new Font("helvetica",Font.PLAIN,17));
		sexo.setHorizontalAlignment(JTextField.CENTER);
		
		departamentos = new JComboBox<String>();
		departamentos.setBounds(125,440,140,35);
		departamentos.addItem("SELECCIONE");
		
		municipios = new JComboBox<String>();
		municipios.setBounds(320,440,140,35);
		municipios.addItem("SELECCIONE");
		
		puestoVotacion = new JComboBox<String>();
		puestoVotacion.setBounds(500,440,230,35);
		puestoVotacion.addItem("SELECCIONE PUESTO");
		
		
		agregarCiudadano = new JButton();
		agregarCiudadano.setBounds(325,494,160,35);
		imagenes = new ImageIcon("Resources/botoncrear.png");
		agregarCiudadano.setIcon(imagenes);
		agregarCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		modificarCiudadano = new JButton();
		modificarCiudadano.setBounds(325,494,160,35);
		imagenes = new ImageIcon("Resources/botonmodificar.png");
		modificarCiudadano.setIcon(imagenes);
		modificarCiudadano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		getContentPane().add(fondo);
		fondo.add(cedula);
		fondo.add(fexpedicion);
		fondo.add(lexpedicion);
		fondo.add(apellido1);
		fondo.add(apellido2);
		fondo.add(nombre1);
		fondo.add(nombre2);
		fondo.add(fNacimiento);
		fondo.add(lNacimiento);
		fondo.add(sexo);
		fondo.add(departamentos);
		fondo.add(municipios);
		fondo.add(puestoVotacion);
		fondo.add(agregarCiudadano);
		fondo.add(modificarCiudadano);
	}
	
	public void reestablecerValores()
	{
		cedula.setText("");
		cedula.setEnabled(true);
		fexpedicion.setText("");
		lexpedicion.setText("");
		apellido1.setText("");
		apellido2.setText("");
		nombre1.setText("");
		nombre2.setText("");
		fNacimiento.setText("");
		lNacimiento.setText("");
		sexo.setText("");
		departamentos.setSelectedItem("SELECCIONE");
		municipios.setSelectedItem("SELECCIONE");
		puestoVotacion.setSelectedItem("SELECCIONE PUESTO");
	}
	
	
	public void ingresarValoresModificarCiudadano(String ced, String fex, String lexp, String ap1, String ap2,
			String nom1, String nom2, String fnac, String lnac, String gen, String depar, String mun, String puesto)
	{
		cedula.setText(ced);
		cedula.setEnabled(false);
		fexpedicion.setText(fex);
		lexpedicion.setText(lexp);
		apellido1.setText(ap1);
		apellido2.setText(ap2);
		nombre1.setText(nom1);
		nombre2.setText(nom2);
		fNacimiento.setText(fnac);
		lNacimiento.setText(lnac);
		sexo.setText(gen);
		departamentos.setSelectedItem(depar);
		municipios.setSelectedItem(mun);
		puestoVotacion.setSelectedItem(puesto);
		
		
		
	}

	public String getCedula() {
		return cedula.getText();
	}


	public String getFexpedicion() {
		return fexpedicion.getText();
	}


	public String getLexpedicion() {
		return lexpedicion.getText();
	}

	public String getApellido1() {
		return apellido1.getText();
	}


	public String getApellido2() {
		return apellido2.getText();
	}


	public String getNombre1() {
		return nombre1.getText();
	}

	public String getNombre2() {
		return nombre2.getText();
	}


	public String getfNacimiento() {
		return fNacimiento.getText();
	}

	public String getlNacimiento() {
		return lNacimiento.getText();
	}


	public String getSexo() {
		return sexo.getText();
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

	public JButton getAgregarCiudadano() {
		return agregarCiudadano;
	}

	public JButton getModificarCiudadano() {
		return modificarCiudadano;
	}

	
}
