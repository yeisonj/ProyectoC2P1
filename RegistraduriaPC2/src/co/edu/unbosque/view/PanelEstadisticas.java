package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEstadisticas extends JPanel {

	private JLabel fondo = new JLabel();
	private ImageIcon imagenFondo = new ImageIcon("Resources/panelestadisticas.png");
	private ImageIcon imagenMostrar = new ImageIcon("Resources/botonmostrar.png");
	private ImageIcon imagenGraficas = new ImageIcon("Resources/botonvergraficas.png");
	public JLabel rango18a25 = new JLabel("0");
	public JLabel rango26a29 = new JLabel("0");
	public JLabel rango30a37 = new JLabel("0");
	public JLabel rango38a49 = new JLabel("0");
	public JLabel rango50a66 = new JLabel("0");
	public JLabel rango67 = new JLabel("0");
	public JLabel porcHombres = new JLabel("0");
	public JLabel porcMujeres = new JLabel("0");
	public JLabel numInscritos = new JLabel("0");

	public JComboBox<String> departamentos = new JComboBox<String>();
	public JComboBox<String> municipios = new JComboBox<String>();
	public JComboBox<String> puestovotacion = new JComboBox<String>();
	public JButton bMostrarEst = new JButton();
	public JButton bGraficas = new JButton();

	public PanelEstadisticas() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(true);
		inicializarComponentes();

	}

	public void inicializarComponentes() {

		bMostrarEst.setBounds(584, 165, 160, 35);
		bMostrarEst.setIcon(imagenMostrar);
     	bGraficas.setBounds(492, 479, 190, 35);
		bGraficas.setIcon(imagenGraficas);

		departamentos.setBounds(40, 165, 140, 35);
		departamentos.addItem("TODOS");

		municipios.setBounds(190, 165, 140, 35);
		municipios.addItem("SELECCIONE");

		puestovotacion.setBounds(340, 165, 230, 35);
		puestovotacion.addItem("SELECCIONE PUESTO");

		porcHombres.setBounds(255, 264, 20, 20);
		porcHombres.setForeground(Color.RED);
		porcHombres.setFont(new Font("helvetica", Font.BOLD, 22));

		porcMujeres.setBounds(583, 265, 20, 20);
		porcMujeres.setForeground(Color.RED);
		porcMujeres.setFont(new Font("helvetica", Font.BOLD, 22));

		numInscritos.setBounds(300, 308, 20, 20);
		numInscritos.setForeground(Color.DARK_GRAY);
		numInscritos.setFont(new Font("helvetica", Font.BOLD, 22));

		rango18a25.setBounds(250, 345, 20, 20);
		rango18a25.setForeground(Color.BLUE);
		rango18a25.setFont(new Font("helvetica", Font.BOLD, 22));

		rango26a29.setBounds(250, 393, 20, 20);
		rango26a29.setForeground(Color.BLUE);
		rango26a29.setFont(new Font("helvetica", Font.BOLD, 22));

		rango30a37.setBounds(250, 440, 20, 20);
		rango30a37.setForeground(Color.BLUE);
		rango30a37.setFont(new Font("helvetica", Font.BOLD, 22));

		rango38a49.setBounds(600, 345, 20, 20);
		rango38a49.setForeground(Color.BLUE);
		rango38a49.setFont(new Font("helvetica", Font.BOLD, 22));

		rango50a66.setBounds(600, 393, 20, 20);
		rango50a66.setForeground(Color.BLUE);
		rango50a66.setFont(new Font("helvetica", Font.BOLD, 22));

		rango67.setBounds(600, 440, 20, 20);
		rango67.setForeground(Color.BLUE);
		rango67.setFont(new Font("helvetica", Font.BOLD, 22));

		fondo.setBounds(0, 0, 800, 600);
		fondo.setIcon(imagenFondo);
		fondo.setLayout(null);
		
		add(fondo);
		fondo.add(porcHombres);
		fondo.add(porcMujeres);
		fondo.add(numInscritos);
		fondo.add(rango18a25);
		fondo.add(rango26a29);
		fondo.add(rango30a37);
		fondo.add(rango38a49);
		fondo.add(rango50a66);
		fondo.add(rango67);
		fondo.add(bMostrarEst);
		fondo.add(bGraficas);
		fondo.add(departamentos);
		fondo.add(municipios);
		fondo.add(puestovotacion);
	}

}
