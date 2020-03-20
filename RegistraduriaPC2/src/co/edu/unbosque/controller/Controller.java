package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.Vista;

public class Controller {

	public Vista vista=null;
	public Registraduria registraduria=null;
	
	public Controller(Vista vista, Registraduria registraduria) {
		super();
		this.vista = vista;
		this.registraduria = registraduria;
		//actionListener(this);
	}
	public void actionListener(ActionListener escuchador) {
		
		
	}
	public void actionPerformed(ActionEvent evento) {
		
	}
	
}
