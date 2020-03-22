package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPuestoVotacion extends JPanel {

	private ImageIcon fondo = new ImageIcon("Resources/fondopuestosdevotacion.png");
	private ImageIcon imagenAgregar = new ImageIcon("Resources/botonagregarpvotacion.png");
	private ImageIcon imagenEliminar = new ImageIcon("Resources/botoneliminarpvotacion.png");
	private JLabel fondoPanel = new JLabel();
	public JComboBox<String> comboDepartamentosadd = new JComboBox<String>();
	public JComboBox<String> comboMunicipiosadd = new JComboBox<String>();
	public JComboBox<String> comboDepartamentosDelete = new JComboBox<String>();
	public JComboBox<String> comboMunicipiosDelete = new JComboBox<String>();
	public JComboBox<String> comboPuestovotacionDelete = new JComboBox<String>();
	public JTextField nuevopuesto = new JTextField();
	public JButton agregarPuesto = new JButton();
	public JButton eliminarPuesto = new JButton();

	PanelPuestoVotacion() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		agregarPuesto.setBounds(586, 218, 160, 35);
		agregarPuesto.setIcon(imagenAgregar);
		eliminarPuesto.setBounds(586, 408, 160, 35);
		eliminarPuesto.setIcon(imagenEliminar);

		comboDepartamentosadd.setBounds(40, 218, 140, 35);
		comboDepartamentosadd.addItem("SELECCIONE");

		comboMunicipiosadd.setBounds(190, 218, 140, 35);
		comboMunicipiosadd.addItem("SELECCIONE");

		nuevopuesto.setBounds(340, 218, 230, 35);

		comboDepartamentosDelete.setBounds(40, 408, 140, 35);
		comboDepartamentosDelete.addItem("SELECCIONE");

		comboMunicipiosDelete.setBounds(190, 408, 140, 35);
		comboMunicipiosDelete.addItem("SELECCIONE");

		comboPuestovotacionDelete.setBounds(340, 408, 230, 35);
		comboPuestovotacionDelete.addItem("SELECCIONE PUESTO");

		fondoPanel.setSize(800, 600);
		fondoPanel.setIcon(fondo);
		fondoPanel.setLayout(null);

		add(fondoPanel);
		fondoPanel.add(agregarPuesto);
		fondoPanel.add(eliminarPuesto);
		fondoPanel.add(comboDepartamentosadd);
		fondoPanel.add(comboMunicipiosadd);
		fondoPanel.add(nuevopuesto);
		fondoPanel.add(comboDepartamentosDelete);
		fondoPanel.add(comboMunicipiosDelete);
		fondoPanel.add(comboPuestovotacionDelete);

	}

}
