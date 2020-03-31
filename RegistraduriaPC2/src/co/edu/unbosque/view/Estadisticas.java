package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Estadisticas extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondo;
	
	private JComboBox<String> departamentos;
	private JComboBox<String> municipios;
	private JComboBox<String> puestovotacion;
	
	
	private JLabel rango1;
	private JLabel rango2;
	private JLabel rango3;
	private JLabel rango4;
	private JLabel rango5;
	private JLabel rango6;
	
	private JLabel porcHombres;
	private JLabel porcMujeres;
	private JLabel numInscritos;
	
	private JButton mostrar;
	private JButton graficas;
	
	
	
	public Estadisticas()
	{
		
		setSize(800, 640);
		setTitle("ESTADISTICAS");
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
		imagenes = new ImageIcon("Resources/panelestadisticas.png");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		
		
		mostrar = new JButton();
		mostrar.setBounds(584,165,160,35);
		imagenes = new ImageIcon("Resources/botonmostrar.png");
		mostrar.setIcon(imagenes);
		mostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		graficas = new JButton();
		graficas.setBounds(492,479,190,35);
		imagenes = new ImageIcon("Resources/botonvergraficas.png");
		graficas.setIcon(imagenes);
		graficas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		departamentos = new JComboBox<String>();
		departamentos.setBounds(40,165,140,35);
		departamentos.addItem("TODOS");
		
		municipios = new JComboBox<String>();
		municipios.setBounds(190,165,140,35);
		municipios.addItem("SELECCIONE");
		
		puestovotacion = new JComboBox<String>();
		puestovotacion.setBounds(340,165,230,35);
		puestovotacion.addItem("SELECCIONE PUESTO");
		
		porcHombres = new JLabel("0");
		porcHombres.setBounds(255,264,20,20);
		porcHombres.setForeground(Color.RED);
		porcHombres.setFont(new Font("helvetica",Font.BOLD,22));
		
		porcMujeres = new JLabel("0");
		porcMujeres.setBounds(583,265,20,20);
		porcMujeres.setForeground(Color.RED);
		porcMujeres.setFont(new Font("helvetica",Font.BOLD,22));
		
		numInscritos = new JLabel("0");
		numInscritos.setBounds(300,308,20,20);
		numInscritos.setForeground(Color.DARK_GRAY);
		numInscritos.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango1 = new JLabel("0");
		rango1.setBounds(250,345,20,20);
		rango1.setForeground(Color.BLUE);
		rango1.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango2 = new JLabel("0");
		rango2.setBounds(250,393,20,20);
		rango2.setForeground(Color.BLUE);
		rango2.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango3 = new JLabel("0");
		rango3.setBounds(250,440,20,20);
		rango3.setForeground(Color.BLUE);
		rango3.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango4 = new JLabel("0");
		rango4.setBounds(600,345,20,20);
		rango4.setForeground(Color.BLUE);
		rango4.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango5 = new JLabel("0");
		rango5.setBounds(600,393,20,20);
		rango5.setForeground(Color.BLUE);
		rango5.setFont(new Font("helvetica",Font.BOLD,22));
		
		rango6 = new JLabel("0");
		rango6.setBounds(600,440,20,20);
		rango6.setForeground(Color.BLUE);
		rango6.setFont(new Font("helvetica",Font.BOLD,22));
		
		
	
		
		getContentPane().add(fondo);
		fondo.add(porcHombres);
		fondo.add(porcMujeres);	
		fondo.add(numInscritos);
		fondo.add(rango1);
		fondo.add(rango2);	
		fondo.add(rango3);
		fondo.add(rango4);
		fondo.add(rango5);	
		fondo.add(rango6);
		fondo.add(mostrar);
		fondo.add(graficas);
		fondo.add(departamentos);
		fondo.add(municipios);
		fondo.add(puestovotacion);
	}
	
	public void reestablecerValores()
	{
		porcHombres.setText("0");
		porcMujeres.setText("0");
		numInscritos.setText("0");
		rango1.setText("0");
		rango2.setText("0");
		rango3.setText("0");
		rango4.setText("0");
		rango5.setText("0");
		rango6.setText("0");
		departamentos.setSelectedItem("TODOS");
		municipios.setSelectedItem("SELECCIONE");
		puestovotacion.setSelectedItem("SELECCIONE PUESTO");
	}
	public JLabel getRango1() {
		return rango1;
	}

	public JLabel getRango2() {
		return rango2;
	}

	public JLabel getRango3() {
		return rango3;
	}

	public JLabel getRango4() {
		return rango4;
	}

	public JLabel getRango5() {
		return rango5;
	}

	public JLabel getRango6() {
		return rango6;
	}

	public JLabel getPorcHombres() {
		return porcHombres;
	}

	public JLabel getPorcMujeres() {
		return porcMujeres;
	}

	public JLabel getNumInscritos() {
		return numInscritos;
	}


	public JComboBox<String> getDepartamentos() {
		return departamentos;
	}

	public JComboBox<String> getMunicipios() {
		return municipios;
	}

	public JComboBox<String> getPuestovotacion() {
		return puestovotacion;
	}

	public JButton getMostrar() {
		return mostrar;
	}

	public JButton getGraficas() {
		return graficas;
	}
	
}
