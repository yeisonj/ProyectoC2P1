package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view = null;
	private Registraduria registraduria = null;

	public Controller(View vista, Registraduria registraduria) {
		super();
		this.view = vista;
		this.registraduria = registraduria;
		actionListener(this);
	}

	public void actionListener(ActionListener escuchador) {
		view.pView.bCiudadanos.addActionListener(escuchador);
		view.pView.bEstadisticas.addActionListener(escuchador);
		view.pView.bPuestovotacion.addActionListener(escuchador);
		view.estadisticas.pEstadisticas.bGraficas.addActionListener(escuchador);
	}

	public void actionPerformed(ActionEvent evento) {

		if (view.pView.bCiudadanos == evento.getSource()) {

		}
		if (view.pView.bEstadisticas == evento.getSource()) {
			view.estadisticas.setVisible(true);
		}
		if (view.pView.bPuestovotacion == evento.getSource()) {
			view.puestovotacion.setVisible(true);
		}
		if(view.estadisticas.pEstadisticas.bGraficas== evento.getSource()) {
			view.estadisticas.graficas.setVisible(true);
		}

	}

}
