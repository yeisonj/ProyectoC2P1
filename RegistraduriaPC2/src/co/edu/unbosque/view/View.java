package co.edu.unbosque.view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame {
	
	private PuestoVotacion pPuestoVotacion;
	private Estadisticas pEstadisticas;
	private Graficas pGraficas;
	private Principal pPrincipal;
	private AgregarModificarCiudadano pAgregarModificar;
	private Ciudadano pCiudadano;
	private ListarCiudadano lCiudadano;
	
	public View()
	{
		pPrincipal = new Principal();
		pPrincipal.setLayout(null);
		pPrincipal.setSize(800, 640);
		pPrincipal.setTitle("PRINCIPAL");
		pPrincipal.setLayout(null);
		pPrincipal.setLocationRelativeTo(null);
		pPrincipal.setResizable(false);
		pPrincipal.setVisible(true);
		pPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		pPuestoVotacion = new PuestoVotacion();

		pEstadisticas = new Estadisticas();
	
		pGraficas = new Graficas();
		
		pAgregarModificar = new AgregarModificarCiudadano();
		
		pCiudadano = new Ciudadano();
		
		lCiudadano = new ListarCiudadano();
		
		
		cambiarIcono();
		
	}
	
	
	public void cambiarIcono()
	{
		ImageIcon icono = new ImageIcon("Resources/icono.png");
		Image image = icono.getImage();
		setIconImage(image);
		pEstadisticas.setIconImage(image);
		pGraficas.setIconImage(image);
		pPuestoVotacion.setIconImage(image);
		pCiudadano.setIconImage(image);
		pPrincipal.setIconImage(image);
		pAgregarModificar.setIconImage(image);
		lCiudadano.setIconImage(image);
	}
	
	public String mostrarMensajes(String mensaje)
	{
		if(mensaje.equalsIgnoreCase("CREAR_TRUE"))
		{
			JOptionPane.showMessageDialog(null, "SE AGREGÓ AL CIUDADANO CORRECTAMENTE");
		}
		if(mensaje.equalsIgnoreCase("MODIFICAR_TRUE"))
		{
			JOptionPane.showMessageDialog(null, "SE MODIFICADO CORRECTAMENTE");
		}
		if(mensaje.equalsIgnoreCase("CREAR_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "EL CIUDADANO YA EXISTE EN LA BASE DE DATOS");
		}
		if(mensaje.equalsIgnoreCase("DEBE_LLENAR_CAMPOS"))
		{
			JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
		}
		
		if(mensaje.equalsIgnoreCase("MODIFICAR"))
		{
			String modificar = JOptionPane.showInputDialog("INGRESE EL NÚMERO DE CEDULA DEL CIUDADANO A MODIFICAR");
			return modificar;
		}
		if(mensaje.equalsIgnoreCase("NO_EXISTE"))
		{
			JOptionPane.showMessageDialog(null,"EL CIUDADANO NO EXISTE EN LA BASE DE DATOS");
		}
		
		if(mensaje.equalsIgnoreCase("ELIMINAR_TRUE"))
		{		
			JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL CIUDADANO");
		}
		if(mensaje.equalsIgnoreCase("ELIMINAR_FALSE"))
		{		
			JOptionPane.showMessageDialog(null,"EL CIUDADANO NO EXISTE");
		}
		if(mensaje.equalsIgnoreCase("AGREGARPUESTO_TRUE"))
		{		
			JOptionPane.showMessageDialog(null,"SE AGREGO EL PUESTO CORRECTAMENTE");
		}
		if(mensaje.equalsIgnoreCase("AGREGARPUESTO_FALSE"))
		{		
			JOptionPane.showMessageDialog(null,"EL PUESTO DE VOTACION YA EXISTE");
		}
		if(mensaje.equalsIgnoreCase("AGREGARPUESTO_BLANCO"))
		{		
			JOptionPane.showMessageDialog(null,"DEBE DIGITAR TODOS LOS CAMPOS");
		}
		if(mensaje.equalsIgnoreCase("ELIMINARPUESTO_BLANCO"))
		{		
			JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR TODOS LOS CAMPOS");
		}
		
		if(mensaje.equalsIgnoreCase("ELIMINARPUESTO_TRUE"))
		{		
			JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL PUESTO DE VOTACION");
		}
		
		if(mensaje.equalsIgnoreCase("SIN_ESTADISTICAS"))
		{
			JOptionPane.showMessageDialog(null,"NO HAY CIUDADANOS REGISTRADOS");
		}
		
		if(mensaje.equalsIgnoreCase("CEDULA_INVALIDA"))
		{
			JOptionPane.showMessageDialog(null,"INGRESE UN NÚMERO DE CÉDULA VÁLIDO");
		}
		return null;
		
	}


	public PuestoVotacion getpPuestoVotacion() {
		return pPuestoVotacion;
	}
	
	public Estadisticas getpEstadisticas() {
		return pEstadisticas;
	}

	public Graficas getpGraficas() {
		return pGraficas;
	}

	public Principal getpPrincipal() {
		return pPrincipal;
	}

	public AgregarModificarCiudadano getpAgregarModificar() {
		return pAgregarModificar;
	}

	public Ciudadano getpCiudadano() {
		return pCiudadano;
	}

	public ListarCiudadano getlCiudadano() {
		return lCiudadano;
	}
	
}
