package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view ;
	private Registraduria registraduria = null;

	public Controller(View view, Registraduria registraduria) {
		super();
		this.view = view;
		this.registraduria = registraduria;
		actionListener(this);
	}

	
public void actionListener(ActionListener escuchador) {
		
		//listeners principal
		view.getpPrincipal().getbCiudadanos().addActionListener(escuchador);
		view.getpPrincipal().getbEstadisticas().addActionListener(escuchador);
		view.getpPrincipal().getbPuestoVotacion().addActionListener(escuchador);
		
		//listeners ciudadanos
		view.getpCiudadano().getAgregarCiudadano().addActionListener(escuchador);
		view.getpCiudadano().getModificarCiudadano().addActionListener(escuchador);
		view.getpCiudadano().getMostrarInformacionCiudadano().addActionListener(escuchador);
		view.getpCiudadano().getEliminarCiudadano().addActionListener(escuchador);
		
		//listeners agregaromodificarciudadano
		view.getpAgregarModificar().getAgregarCiudadano().addActionListener(escuchador);
		view.getpAgregarModificar().getModificarCiudadano().addActionListener(escuchador);

		//listeners Estadísticas
		view.getpEstadisticas().getGraficas().addActionListener(escuchador);
		view.getpEstadisticas().getMostrar().addActionListener(escuchador);
		
		//listeners puestosdevotación
		view.getpPuestoVotacion().getAgregarpuesto().addActionListener(escuchador);
		view.getpPuestoVotacion().getEliminarpuesto().addActionListener(escuchador);
		
		//listeners listar Ciudadanos
		view.getlCiudadano().getValidarCedula().addActionListener(escuchador);
		view.getlCiudadano().getValidarinfogeneral().addActionListener(escuchador);
		
		
		
		
	}

	public void actionPerformed(ActionEvent evento) {

		if(evento.getSource() == view.getpPrincipal().getbCiudadanos())
		{
			view.getpCiudadano().setVisible(true);
		}
		
		
		if(evento.getSource() == view.getpPrincipal().getbEstadisticas())
		{
			view.getpEstadisticas().setVisible(true);
		}
		
		
		if(evento.getSource() == view.getpPrincipal().getbPuestoVotacion())
		{
			view.getpPuestoVotacion().setVisible(true);
		}
		
		if(evento.getSource() == view.getpEstadisticas().getGraficas())
		{
			view.getpGraficas().setVisible(true);
		}
		
		
		if(evento.getSource() == view.getpCiudadano().getAgregarCiudadano())
		{
			view.getpAgregarModificar().setVisible(true);
			view.getpAgregarModificar().getAgregarCiudadano().setVisible(true);
			view.getpAgregarModificar().getModificarCiudadano().setVisible(false);
			view.getpAgregarModificar().reestablecerValores();
			
		}
		
		if(evento.getSource() == view.getpCiudadano().getModificarCiudadano())
		{
			String opcion = JOptionPane.showInputDialog(null,"INGRESE EL NÚMERO DE CÉDULA DEL CIUDADANO");
			
			try{
			if(opcion.equals(""))
			{
				JOptionPane.showMessageDialog(null,"NO HA INGRESADO NINGÚN DATO");
			}
			else {
				view.getpAgregarModificar().ingresarValoresModificarCiudadano("1016071185","22/11/10","Bogotá","TORRES","JIMÉNEZ",
					"DIEGO","FERNANDO", "19/11/1994","BOGOTÁ","MASCULINO","SELECCIONE","SELECCIONE","SELECCIONE PUESTO");
				view.getpAgregarModificar().setVisible(true);
				view.getpAgregarModificar().getModificarCiudadano().setVisible(true);
				view.getpAgregarModificar().getAgregarCiudadano().setVisible(false);
			}
			}
			catch(Exception e)
			{
				
			}
		}
		
		
		if(evento.getSource() == view.getpCiudadano().getMostrarInformacionCiudadano())
		{
			view.getlCiudadano().setVisible(true);
		}
		
		if(evento.getSource() == view.getpCiudadano().getEliminarCiudadano())
		{
			String opcion = JOptionPane.showInputDialog(null,"INSERTE N DE CÉDULA DEL CIUDADANO A ELIMINAR");
			try{
				if(opcion.equals(""))
				{
					JOptionPane.showMessageDialog(null,"NO HA INGRESADO NINGÚN DATO");
				}
				else {
				}
				}
				catch(Exception e)
				{
					
				}
			
		}
		
		

	}

}
