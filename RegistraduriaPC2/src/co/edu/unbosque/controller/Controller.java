package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		view.getpPrincipal().getbCiudadanos().addActionListener(escuchador);
		view.getpPrincipal().getbEstadisticas().addActionListener(escuchador);
		view.getpPrincipal().getbPuestoVotacion().addActionListener(escuchador);
		
	}

	public void actionPerformed(ActionEvent evento) {

		if(evento.getSource() == view.getpPrincipal().getbCiudadanos())
		{
			
		}
		
		if(evento.getSource() == view.getpPrincipal().getbEstadisticas())
		{
			view.getpEstadisticas().setVisible(true);
		}
		
		if(evento.getSource() == view.getpPrincipal().getbPuestoVotacion())
		{
			view.getpPuestoVotacion().setVisible(true);
		}
		
		
		

	}

}
