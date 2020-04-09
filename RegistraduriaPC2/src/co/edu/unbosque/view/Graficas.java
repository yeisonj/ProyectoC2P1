package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;



/**
 * <h1>Modela una clase extendida de JFrame Graficas </h1>
*Esta Clase se encarga de mostrar gráficas de las estadisticas del programa
* @version 1.0
* @author Diego Torres | Universidad El Bosque
 */

public class Graficas extends JFrame{

	private ImageIcon imagenes;
	private JLabel fondo;
	private JLabel localizacion;
	
	private DefaultPieDataset tortagenero;
	private DefaultPieDataset tortagenero3d;
	private DefaultPieDataset tortarango;
	private DefaultPieDataset tortarango3d;
	private DefaultCategoryDataset barrasgenero;
	private DefaultCategoryDataset barrasgenero3d;
	private DefaultCategoryDataset barrasrango;
	private DefaultCategoryDataset barrasrango3d;
	
	private ChartPanel panelgenerotorta;
	private ChartPanel panelgenerotorta3d;
	private ChartPanel panelgenerobarras;
	private ChartPanel panelgenerobarras3d;
	private ChartPanel panelrangobarras;
	private ChartPanel panelrangobarras3d;
	private ChartPanel panelrangotorta;
	private ChartPanel panelrangotorta3d;
	
	
	private ArrayList<JButton> botones;
	
	
	
	/**Constructor de la clase Graficas, se encarga de inicializar componentes principales como tamaño, ubicación,
	 * si es o no redimensionable y layout
	 */
	
	public Graficas()
	{
		setSize(800, 640);
		setTitle("GRAFICAS");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		inicializarComponentes();
	}
	
	/**esta clase se encarga de inicializar todas las gráficas de la Clase Graficas
	 * 
	 */
	public void inicializarComponentes()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenes = new ImageIcon("Resources/panelgraficas.png");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		getContentPane().add(fondo);
		
		localizacion = new JLabel("PRUEBA DE LOCALIZACIÓN");
		localizacion.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		localizacion.setForeground(Color.WHITE);
		localizacion.setBounds(320,110,370,30);
		
		tortagenero = new DefaultPieDataset();
		JFreeChart jfreegenerotorta = ChartFactory.createPieChart("",tortagenero);
		panelgenerotorta = new ChartPanel(jfreegenerotorta);
		panelgenerotorta.setBounds(30,172,350,250);
		PiePlot plot0 = (PiePlot) jfreegenerotorta.getPlot();
        plot0.setForegroundAlpha(0.9f);
        plot0.setNoDataMessage("sin Datos");
        plot0.setBackgroundPaint(Color.WHITE);
        
		
		tortagenero3d = new DefaultPieDataset();
		JFreeChart jfreegenerotorta3d = ChartFactory.createPieChart3D("",tortagenero);
		panelgenerotorta3d = new ChartPanel(jfreegenerotorta3d);
		panelgenerotorta3d.setBounds(30,172,350,250);
		PiePlot3D plot1 = (PiePlot3D) jfreegenerotorta3d.getPlot();
        plot1.setStartAngle(150);
        plot1.setForegroundAlpha(0.5f);
        plot1.setNoDataMessage("sin Datos");
        plot1.setBackgroundPaint(Color.white);
        plot1.setDarkerSides(true);
       
		
		tortarango = new DefaultPieDataset();
		JFreeChart jfreerangotorta = ChartFactory.createPieChart("",tortarango);
		panelrangotorta = new ChartPanel(jfreerangotorta);
		panelrangotorta.setBounds(410,172,350,250);
		PiePlot plot2 = (PiePlot) jfreerangotorta.getPlot();
        plot2.setForegroundAlpha(0.9f);
        plot2.setNoDataMessage("sin Datos");
        plot2.setBackgroundPaint(Color.WHITE);
		
		tortarango3d = new DefaultPieDataset();
		JFreeChart jfreerangotorta3d = ChartFactory.createPieChart3D("",tortarango);
		panelrangotorta3d = new ChartPanel(jfreerangotorta3d);
		panelrangotorta3d.setBounds(410,172,350,250);
		PiePlot3D plot3 = (PiePlot3D) jfreerangotorta3d.getPlot();
        plot3.setStartAngle(150);
        plot3.setForegroundAlpha(0.5f);
        plot3.setNoDataMessage("sin Datos");
        plot3.setBackgroundPaint(Color.white);
        plot3.setDarkerSides(true);
		
		barrasgenero = new DefaultCategoryDataset();
		JFreeChart jfreegenerobarras =ChartFactory.createBarChart("","Género","Inscritos", barrasgenero,PlotOrientation.VERTICAL,true,true,false);
		panelgenerobarras =new ChartPanel(jfreegenerobarras);
		panelgenerobarras.setBounds(30,172,350,250);
		
		barrasgenero3d = new DefaultCategoryDataset();
		JFreeChart jfreegenerobarras3d =ChartFactory.createBarChart3D("","Género","Inscritos", barrasgenero3d,PlotOrientation.VERTICAL,true,true,false);
		panelgenerobarras3d =new ChartPanel(jfreegenerobarras3d);
		panelgenerobarras3d.setBounds(30,172,350,250);
		
		
	    barrasrango = new DefaultCategoryDataset();
	    JFreeChart jfreerangobarras =ChartFactory.createBarChart("","Edad","Inscritos",barrasrango,PlotOrientation.VERTICAL,true,true,false);
		panelrangobarras =new ChartPanel(jfreerangobarras);
		panelrangobarras.setBounds(410,172,350,250);
		
		barrasrango3d = new DefaultCategoryDataset();
	    JFreeChart jfreerangobarras3d =ChartFactory.createBarChart3D("","Edad","Inscritos",barrasrango3d,PlotOrientation.VERTICAL,true,true,false);
		panelrangobarras3d =new ChartPanel(jfreerangobarras3d);
		panelrangobarras3d.setBounds(410,172,350,250);
			    
		
		botones = new ArrayList<JButton>();
		
		JButton boton1 = new JButton();
		boton1.setBounds(73,487,110,30);
		imagenes = new ImageIcon("Resources/boton2d.png");
		boton1.setIcon(imagenes);
		boton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton2 = new JButton();
		boton2.setBounds(73,535,110,30);
		imagenes = new ImageIcon("Resources/boton3d.png");
		boton2.setIcon(imagenes);
		boton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton3 = new JButton();
		boton3.setBounds(228,487,110,30);
		imagenes = new ImageIcon("Resources/boton2d.png");
		boton3.setIcon(imagenes);
		boton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton4 = new JButton();
		boton4.setBounds(228,535,110,30);
		imagenes = new ImageIcon("Resources/boton3d.png");
		boton4.setIcon(imagenes);
		boton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton5 = new JButton();
		boton5.setBounds(450,487,110,30);
		imagenes = new ImageIcon("Resources/boton2d.png");
		boton5.setIcon(imagenes);
		boton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton6 = new JButton();
		boton6.setBounds(450,535,110,30);
		imagenes = new ImageIcon("Resources/boton3d.png");
		boton6.setIcon(imagenes);
		boton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton7 = new JButton();
		boton7.setBounds(600,487,110,30);
		imagenes = new ImageIcon("Resources/boton2d.png");
		boton7.setIcon(imagenes);
		boton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton boton8 = new JButton();
		boton8.setBounds(600,535,110,30);
		imagenes = new ImageIcon("Resources/boton3d.png");
		boton8.setIcon(imagenes);
		boton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botones.add(boton1);
		botones.add(boton2);
		botones.add(boton3);
		botones.add(boton4);
		botones.add(boton5);
		botones.add(boton6);
		botones.add(boton7);
		botones.add(boton8);
		
		
		fondo.add(panelgenerotorta);
		fondo.add(panelrangotorta);
		fondo.add(panelgenerobarras);
		fondo.add(panelrangobarras);
		fondo.add(panelgenerotorta3d);
		fondo.add(panelrangotorta3d);
		fondo.add(panelgenerobarras3d);
		fondo.add(panelrangobarras3d);
		fondo.add(localizacion);
		fondo.add(boton1);
		fondo.add(boton2);
		fondo.add(boton3);
		fondo.add(boton4);
		fondo.add(boton5);
		fondo.add(boton6);
		fondo.add(boton7);
		fondo.add(boton8);
		
		
	}
	/**Método que se encarga de agregar valores a las gráficas
	 * 
	 * @param femenino tipo double, recibe el porcentaje femeníno de las estadísticas
	 * @param masculino tipo double, recibe el porcentaje masculino de las estadísticas
	 * @param r1 tipo int, recibe la cantidad de ciudadanos en el rango 1
	 * @param r2 tipo int, recibe la cantidad de ciudadanos en el rango 2
	 * @param r3 tipo int, recibe la cantidad de ciudadanos en el rango 3
	 * @param r4 tipo int, recibe la cantidad de ciudadanos en el rango 4
	 * @param r5 tipo int, recibe la cantidad de ciudadanos en el rango 5
	 * @param r6 tipo int, recibe la cantidad de ciudadanos en el rango 6
	 */
	
	public void graficas( double femenino, double masculino, int r1, int r2, int r3, int r4, int r5, int r6)
	{	
		int total = r1+r2+r3+r4+r5+r6;
		
		double masc = (double) (masculino*total/100);
		double fem = (double) (femenino*total/100);
		
		tortagenero.setValue("Hombres", masculino);
		tortagenero.setValue("Mujeres", femenino);
		
		tortagenero3d.setValue("Hombres", masculino);
		tortagenero3d.setValue("Mujeres", femenino);
		
		tortarango.setValue("Rango 1", r1);
		tortarango.setValue("Rango 2", r2);
		tortarango.setValue("Rango 3", r3);
		tortarango.setValue("Rango 4", r4);
		tortarango.setValue("Rango 5", r5);
		tortarango.setValue("Rango 6", r6);
		
		tortarango3d.setValue("Rango 1", r1);
		tortarango3d.setValue("Rango 2", r2);
		tortarango3d.setValue("Rango 3", r3);
		tortarango3d.setValue("Rango 4", r4);
		tortarango3d.setValue("Rango 5", r5);
		tortarango3d.setValue("Rango 6", r6);
		
		
		barrasgenero.addValue(masc, "HOMBRES", "hombres");
		barrasgenero.addValue(fem, "MUJERES", "mujeres");
		
		barrasgenero3d.addValue(masc, "HOMBRES", "hombres");
		barrasgenero3d.addValue(fem, "MUJERES", "mujeres");
		
		barrasrango.addValue(r1, "18-25", "R1");
		barrasrango.addValue(r2, "26-29", "R2");
		barrasrango.addValue(r3, "30-37", "R3");
		barrasrango.addValue(r4, "38-49", "R4");
		barrasrango.addValue(r5, "50-66", "R5");
		barrasrango.addValue(r6, "67 >", "R6");
		
		barrasrango3d.addValue(r1, "18-25", "R1");
		barrasrango3d.addValue(r2, "26-29", "R2");
		barrasrango3d.addValue(r3, "30-37", "R3");
		barrasrango3d.addValue(r4, "38-49", "R4");
		barrasrango3d.addValue(r5, "50-66", "R5");
		barrasrango3d.addValue(r6, "67 >", "R6");
		
		
	}

	public JLabel getLocalizacion() {
		return localizacion;
	}

	public ChartPanel getPanelgenerotorta() {
		return panelgenerotorta;
	}

	public ChartPanel getPanelgenerotorta3d() {
		return panelgenerotorta3d;
	}

	public ChartPanel getPanelgenerobarras() {
		return panelgenerobarras;
	}

	public ChartPanel getPanelgenerobarras3d() {
		return panelgenerobarras3d;
	}

	public ChartPanel getPanelrangobarras() {
		return panelrangobarras;
	}

	public ChartPanel getPanelrangobarras3d() {
		return panelrangobarras3d;
	}

	public ChartPanel getPanelrangotorta() {
		return panelrangotorta;
	}

	public ChartPanel getPanelrangotorta3d() {
		return panelrangotorta3d;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}
	
	
	
	
	
}
