package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.PanelEstadisticas;
import co.edu.unbosque.view.PanelGraficas;
import co.edu.unbosque.view.PanelPuestoVotacion;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View vista;
	private Registraduria registraduria=null;
	private PanelEstadisticas pEstadisticas;
	private PanelGraficas pGraficas;
	private PanelPuestoVotacion pPuesto;
	
	
	public Controller(View vista, Registraduria registraduria) {
		super();
		this.vista = vista;
		this.registraduria = registraduria;
		this.pEstadisticas = vista.getpEstadisticas();
		this.pPuesto = vista.getpPuestoVotacion();
		this.pGraficas = vista.getpGraficas();
		
		setActionListener();
	}
	
	public void setActionListener()
	{
		vista.getpEstadisticas().getVolver().addActionListener(this);
		vista.getpPuestoVotacion().getVolver().addActionListener(this);
		vista.getpGraficas().getVolver().addActionListener(this);
		
		
		vista.getEstadisticas().addActionListener(this);
		vista.getPuestovotacion().addActionListener(this);
		vista.getpEstadisticas().getGraficas().addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource()==vista.getEstadisticas())
		{
			vista.getpEstadisticas().setVisible(true);
			vista.getPrincipal().setVisible(false);
			vista.getpPuestoVotacion().setVisible(false);
			vista.getpGraficas().setVisible(false);
			
		}
		
		if(evento.getSource()==vista.getPuestovotacion())
		{
			vista.getpEstadisticas().setVisible(false);
			vista.getPrincipal().setVisible(false);
			vista.getpPuestoVotacion().setVisible(true);
			vista.getpGraficas().setVisible(false);
			
		}
		
		if(evento.getSource()==vista.getpEstadisticas().getGraficas())
		{
			vista.getpEstadisticas().setVisible(false);
			vista.getPrincipal().setVisible(false);
			vista.getpPuestoVotacion().setVisible(false);
			vista.getpGraficas().setVisible(true);
			
		}
		
		if(evento.getSource()==vista.getpEstadisticas().getVolver())
		{
			vista.getpEstadisticas().setVisible(false);
			vista.getPrincipal().setVisible(true);
			vista.getpPuestoVotacion().setVisible(false);
			vista.getpGraficas().setVisible(false);
			
		}
		
		if(evento.getSource()==vista.getpPuestoVotacion().getVolver())
		{
			vista.getpEstadisticas().setVisible(false);
			vista.getPrincipal().setVisible(true);
			vista.getpPuestoVotacion().setVisible(false);
			vista.getpGraficas().setVisible(false);
			
		}
		
		if(evento.getSource()==vista.getpGraficas().getVolver())
		{
			vista.getpEstadisticas().setVisible(true);
			vista.getPrincipal().setVisible(false);
			vista.getpPuestoVotacion().setVisible(false);
			vista.getpGraficas().setVisible(false);
			
		}
		
		
		
		
	}
	
}
