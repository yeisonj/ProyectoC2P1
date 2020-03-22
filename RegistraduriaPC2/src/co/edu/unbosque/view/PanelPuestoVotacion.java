package co.edu.unbosque.view;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPuestoVotacion extends JPanel {

	private ImageIcon fondo;
	private ImageIcon imagen;
	private JLabel fondoPanel;
	private JComboBox<String> departamentos;
	private JComboBox<String> municipios;
	private JComboBox<String> departamentos2;
	private JComboBox<String> municipios2;
	private JComboBox<String> puestovotacion;
	private JTextField nuevopuesto;
	private JButton agregar;
	private JButton eliminar;
	private JButton volver;
	
	
	PanelPuestoVotacion () 
	{
		panelDeControl();
	}
	
	public void panelDeControl()
	{
		
		fondoPanel = new JLabel();
		fondoPanel.setSize(800,600);
		fondo = new ImageIcon("Resources/fondopuestosdevotacion.png");
		fondoPanel.setIcon(fondo);
		fondoPanel.setLayout(null);
		
	
		agregar = new JButton();
		agregar.setBounds(586,218,160,35);
		imagen = new ImageIcon("Resources/botonagregarpvotacion.png");
		agregar.setIcon(imagen);
		
		eliminar = new JButton();
		eliminar.setBounds(586,408,160,35);
		imagen = new ImageIcon("Resources/botoneliminarpvotacion.png");
		eliminar.setIcon(imagen);
		
		volver = new JButton();
		volver.setBounds(586,550,160,35);
		imagen = new ImageIcon("Resources/botonvolver.png");
		volver.setIcon(imagen);
		
		departamentos = new JComboBox<String>();
		departamentos.setBounds(40,218,140,35);
		departamentos.addItem("SELECCIONE");
		
		municipios = new JComboBox<String>();
		municipios.setBounds(190,218,140,35);
		municipios.addItem("SELECCIONE");
		
		nuevopuesto = new JTextField();
		nuevopuesto.setBounds(340,218,230,35);
		
		
		departamentos2 = new JComboBox<String>();
		departamentos2.setBounds(40,408,140,35);
		departamentos2.addItem("SELECCIONE");
		
		municipios2 = new JComboBox<String>();
		municipios2.setBounds(190,408,140,35);
		municipios2.addItem("SELECCIONE");
		
		puestovotacion = new JComboBox<String>();
		puestovotacion.setBounds(340,408,230,35);
		puestovotacion.addItem("SELECCIONE PUESTO");
		
		
		add(fondoPanel);
		fondoPanel.add(agregar);
		fondoPanel.add(eliminar);
		fondoPanel.add(volver);
		fondoPanel.add(departamentos);
		fondoPanel.add(municipios);
		fondoPanel.add(nuevopuesto);
		fondoPanel.add(departamentos2);
		fondoPanel.add(municipios2);
		fondoPanel.add(puestovotacion);
		
	}

	public JComboBox<String> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(JComboBox<String> departamentos) {
		this.departamentos = departamentos;
	}

	public JComboBox<String> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(JComboBox<String> municipios) {
		this.municipios = municipios;
	}

	public JComboBox<String> getDepartamentos2() {
		return departamentos2;
	}

	public void setDepartamentos2(JComboBox<String> departamentos2) {
		this.departamentos2 = departamentos2;
	}

	public JComboBox<String> getMunicipios2() {
		return municipios2;
	}

	public void setMunicipios2(JComboBox<String> municipios2) {
		this.municipios2 = municipios2;
	}

	public JComboBox<String> getPuestovotacion() {
		return puestovotacion;
	}

	public void setPuestovotacion(JComboBox<String> puestovotacion) {
		this.puestovotacion = puestovotacion;
	}

	public JTextField getNuevopuesto() {
		return nuevopuesto;
	}

	public void setNuevopuesto(JTextField nuevopuesto) {
		this.nuevopuesto = nuevopuesto;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	
	
	
	
}
