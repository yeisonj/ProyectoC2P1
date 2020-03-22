package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame {

	public Estadisticas estadisticas=new Estadisticas();
	public PuestoVotacion puestovotacion=new PuestoVotacion();
	public PanelView pView = new PanelView();

	public View() {
		//PROPIEDADES DE LA VENTANA
		setSize(800, 640);
		setTitle("INSCRIPCIÓN DE CÉDULAS");
		setLayout(null);
		setLocationRelativeTo(null);// CENTRAR LA VENTANA EN LA PANTALLA
		setResizable(false);// IMPIDE QUE EL USUARIO MODIFIQUE EL TAMAÑO DE LA VENTANA
		setVisible(true);
		add(pView);
		cambiarIcono();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	public void cambiarIcono() {
		ImageIcon icono = new ImageIcon("Resources/icono.png");
		Image image = icono.getImage();
		setIconImage(image);
	}

	// ESTE METODO SE USA PARA MOSTRAR MENSAJES DE NOTIFICACION
	public void mostrarMensajes(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
