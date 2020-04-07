package co.edu.unbosque.view;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas extends JFrame{

	private ImageIcon imagenes;
	private JLabel fondo;
	private ChartPanel genero1;
	private ChartPanel rango1;
	private DefaultPieDataset p;
	
	
	public Graficas()
	{
		setSize(800, 640);
		setTitle("GRAFICAS");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		inicializarComponentes();
	}
	
	public void inicializarComponentes()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenes = new ImageIcon("Resources/panelgraficas.png");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		getContentPane().add(fondo);
		
		
		
	}
	
	
	public void graficasTorta(double femenino, double masculino, int r1, int r2, int r3, int r4, int r5, int r6)
	{	
		
		p = new DefaultPieDataset();
		p.addChangeListener(null);
		p.setValue("Hombres", masculino);
		p.setValue("Mujeres", femenino);
	
		
		JFreeChart j = ChartFactory.createPieChart("",p);
		genero1 = new ChartPanel(j);
		genero1.setBounds(58,162,270,180);
		
		
		DefaultPieDataset q = new DefaultPieDataset();
		q.setValue("Rango 1", r1);
		q.setValue("Rango 2", r2);
		q.setValue("Rango 3", r3);
		q.setValue("Rango 4", r4);
		q.setValue("Rango 5", r5);
		q.setValue("Rango 6", r6);
		
		JFreeChart k = ChartFactory.createPieChart("",q);
		rango1 = new ChartPanel(k);
		rango1.setBounds(420,162,270,180);
		
	
	
		
		fondo.add(genero1);
		fondo.add(rango1);
		
		
		
	}
	
	public void graficasBarras(double femenino,double masculino, int r1, int r2, int r3, int r4, int r5, int r6)
	{
		int total = r1+r2+r3+r4+r5+r6;
		
		int masc = (int) (masculino*total/100);
		int fem = (int) (femenino*total/100);
		
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
		dataset.addValue(masc, "HOMBRES", "hombres");
		dataset.addValue(fem, "MUJERES", "mujeres");
		
		
		 JFreeChart chart=ChartFactory.createBarChart("",
			        "Género",
			        "Inscritos", 
			        dataset,
			        PlotOrientation.VERTICAL,
			        true,true,false
			       );

			    ChartPanel barras =new ChartPanel(chart);
			    barras.setBounds(58,350,270,187);
			
	DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
	dataset2.addValue(r1, "18-25", "R1");
	dataset2.addValue(r2, "26-29", "R2");
	dataset2.addValue(r3, "30-37", "R3");
	dataset2.addValue(r4, "38-49", "R4");
	dataset2.addValue(r5, "50-66", "R5");
	dataset2.addValue(r6, "67 >", "R6");
	
				
	
	JFreeChart chart2 =ChartFactory.createBarChart("","Edad","Inscritos", 
					        dataset2,
					        PlotOrientation.VERTICAL,
					        true,true,false
					       );

					    ChartPanel barras2 =new ChartPanel(chart2);
					    barras2.setBounds(405,350,300,187);
			    
			    fondo.add(barras);
			    fondo.add(barras2);
	}
	
	
	
}
