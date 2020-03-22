package co.edu.unbosque.view;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PanelGraficas extends JPanel{

	
	private JLabel fondo;
	private ImageIcon imagenFondo;
	private JButton volver;
	
	
	
	public PanelGraficas()
	{
		panelDeControl();
		graficasTorta();
		graficasBarras();
	}
	
	public void panelDeControl()
	{
		fondo = new JLabel();
		fondo.setBounds(0,0,800,600);
		imagenFondo = new ImageIcon("Resources/panelgraficas.png");
		fondo.setIcon(imagenFondo);
		fondo.setLayout(null);
		
		volver = new JButton();
		volver.setBounds(586,550,160,35);
		imagenFondo = new ImageIcon("Resources/botonvolver.png");
		volver.setIcon(imagenFondo);
		
		add(fondo);
		fondo.add(volver);
	}
	
	
	public void graficasTorta()
	{
		
		DefaultPieDataset p = new DefaultPieDataset();
		p.setValue("Hombres", 60);
		p.setValue("Mujeres", 40);
		
		JFreeChart j = ChartFactory.createPieChart("",p);
		ChartPanel genero1 = new ChartPanel(j);
		genero1.setBounds(58,162,270,180);
		
		DefaultPieDataset q = new DefaultPieDataset();
		q.setValue("Rango 1", 30);
		q.setValue("Rango 2", 20);
		q.setValue("Rango 3", 10);
		q.setValue("Rango 4", 10);
		q.setValue("Rango 5", 15);
		q.setValue("Rango 6", 15);
		
		
		JFreeChart k = ChartFactory.createPieChart("",q);
		ChartPanel rango1 = new ChartPanel(k);
		rango1.setBounds(420,162,270,180);
		
	
		
		
		fondo.add(genero1);
		fondo.add(rango1);
		
		
		
	}
	
	public void graficasBarras()
	{
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(60, "HOMBRES", "hombres");
		dataset.addValue(40, "MUJERES", "mujeres");
		
		
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
	dataset2.addValue(10, "18-25", "R1");
	dataset2.addValue(5, "26-29", "R2");
	dataset2.addValue(20, "30-37", "R3");
	dataset2.addValue(13, "38-49", "R4");
	dataset2.addValue(14, "50-66", "R5");
	dataset2.addValue(2, "67 >", "R6");
	
				
	
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

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	
	
	
	
}
