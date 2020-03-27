package co.edu.unbosque.view;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PuestoVotacion extends JFrame {

	private ImageIcon imagenes;
	private JLabel fondoPanel;
	private JComboBox<String> departamentosadd;
	private JComboBox<String> municipiosadd;
	private JComboBox<String> departamentosdelete;
	private JComboBox<String> municipiosdelete;
	private JComboBox<String> puestovotaciondelete;
	private JTextField nuevopuesto;
	private JButton agregarpuesto;
	private JButton eliminarpuesto;
	
	
	public PuestoVotacion() 
	{
		setSize(800, 640);
		setTitle("PUESTOS DE VOTACIÓN");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		inicializarComponentes();
	}
	
	public void inicializarComponentes()
	{
		
		fondoPanel = new JLabel();
		fondoPanel.setSize(800,600);
		imagenes = new ImageIcon("Resources/fondopuestosdevotacion.png");
		fondoPanel.setIcon(imagenes);
		fondoPanel.setLayout(null);
		
	
		agregarpuesto = new JButton();
		agregarpuesto.setBounds(586,218,160,35);
		imagenes = new ImageIcon("Resources/botonagregarpvotacion.png");
		agregarpuesto.setIcon(imagenes);
		
		eliminarpuesto = new JButton();
		eliminarpuesto.setBounds(586,408,160,35);
		imagenes = new ImageIcon("Resources/botoneliminarpvotacion.png");
		eliminarpuesto.setIcon(imagenes);
		
	
		
		departamentosadd = new JComboBox<String>();
		departamentosadd.setBounds(40,218,140,35);
		departamentosadd.addItem("SELECCIONE");
		
		municipiosadd = new JComboBox<String>();
		municipiosadd.setBounds(190,218,140,35);
		municipiosadd.addItem("SELECCIONE");
		
		nuevopuesto = new JTextField();
		nuevopuesto.setBounds(340,218,230,35);
		
		
		departamentosdelete = new JComboBox<String>();
		departamentosdelete.setBounds(40,408,140,35);
		departamentosdelete.addItem("SELECCIONE");
		
		municipiosdelete = new JComboBox<String>();
		municipiosdelete.setBounds(190,408,140,35);
		municipiosdelete.addItem("SELECCIONE");
		
		puestovotaciondelete = new JComboBox<String>();
		puestovotaciondelete.setBounds(340,408,230,35);
		puestovotaciondelete.addItem("SELECCIONE PUESTO");
		
		
		add(fondoPanel);
		fondoPanel.add(agregarpuesto);
		fondoPanel.add(eliminarpuesto);
		fondoPanel.add(departamentosadd);
		fondoPanel.add(municipiosadd);
		fondoPanel.add(nuevopuesto);
		fondoPanel.add(departamentosdelete);
		fondoPanel.add(municipiosdelete);
		fondoPanel.add(puestovotaciondelete);
		
	}

	
	
	

	public JComboBox<String> getDepartamentosadd() {
		return departamentosadd;
	}

	public void setDepartamentosadd(JComboBox<String> departamentosadd) {
		this.departamentosadd = departamentosadd;
	}

	public JComboBox<String> getMunicipiosadd() {
		return municipiosadd;
	}

	public void setMunicipiosadd(JComboBox<String> municipiosadd) {
		this.municipiosadd = municipiosadd;
	}

	public JComboBox<String> getDepartamentosdelete() {
		return departamentosdelete;
	}

	public void setDepartamentosdelete(JComboBox<String> departamentosdelete) {
		this.departamentosdelete = departamentosdelete;
	}

	public JComboBox<String> getMunicipiosdelete() {
		return municipiosdelete;
	}

	public void setMunicipiosdelete(JComboBox<String> municipiosdelete) {
		this.municipiosdelete = municipiosdelete;
	}

	public JComboBox<String> getPuestovotaciondelete() {
		return puestovotaciondelete;
	}

	public void setPuestovotaciondelete(JComboBox<String> puestovotaciondelete) {
		this.puestovotaciondelete = puestovotaciondelete;
	}

	public JButton getAgregarpuesto() {
		return agregarpuesto;
	}

	public void setAgregarpuesto(JButton agregarpuesto) {
		this.agregarpuesto = agregarpuesto;
	}

	public JButton getEliminarpuesto() {
		return eliminarpuesto;
	}

	public void setEliminarpuesto(JButton eliminarpuesto) {
		this.eliminarpuesto = eliminarpuesto;
	}

	public JTextField getNuevopuesto() {
		return nuevopuesto;
	}

	public void setNuevopuesto(JTextField nuevopuesto) {
		this.nuevopuesto = nuevopuesto;
	}

	
	
	
	
}
