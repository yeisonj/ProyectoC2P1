package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Ciudadano;
import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.CiudadanoDAO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View view;
	private Registraduria registraduria;
	private ArrayList<Ciudadano> cedulasInscritas;
	private ArrayList<String> puestosDeVotacion;
	private Archivo archivo;
	private CiudadanoDAO ciudadanodao;

	public Controller() {
		super();
		view = new View();
		registraduria = new Registraduria();
		setActionListener();
		cedulasInscritas = new ArrayList<Ciudadano>();
		puestosDeVotacion = new ArrayList<String>();
		archivo = new Archivo();
		ciudadanodao = new CiudadanoDAO(archivo);
		cedulasInscritas = archivo.leerArchivo();
		puestosDeVotacion = archivo.cargarListaPuestosDeVotacion();

	}

	// MÉTODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA
	public void setActionListener() {

		// listeners principal
		view.getpPrincipal().getbCiudadanos().addActionListener(this);
		view.getpPrincipal().getbEstadisticas().addActionListener(this);
		view.getpPrincipal().getbPuestoVotacion().addActionListener(this);

		// listeners ciudadanos
		view.getpCiudadano().getAgregarCiudadano().addActionListener(this);
		view.getpCiudadano().getModificarCiudadano().addActionListener(this);
		view.getpCiudadano().getMostrarInformacionCiudadano().addActionListener(this);
		view.getpCiudadano().getEliminarCiudadano().addActionListener(this);

		// listeners agregaromodificarciudadano
		view.getpAgregarModificar().getAgregarCiudadano().addActionListener(this);
		view.getpAgregarModificar().getModificarCiudadano().addActionListener(this);
		view.getpAgregarModificar().getDepartamentos().addActionListener(this);
		view.getpAgregarModificar().getMunicipios().addActionListener(this);

		// listeners Estadísticas
		view.getpEstadisticas().getGraficas().addActionListener(this);
		view.getpEstadisticas().getMostrar().addActionListener(this);
		view.getpEstadisticas().getDepartamentos().addActionListener(this);
		view.getpEstadisticas().getMunicipios().addActionListener(this);
		view.getpEstadisticas().getLocalizacion().addActionListener(this);

		// listeners puestosdevotación
		view.getpPuestoVotacion().getAgregarpuesto().addActionListener(this);
		view.getpPuestoVotacion().getEliminarpuesto().addActionListener(this);
		view.getpPuestoVotacion().getDepartamentosdelete().addActionListener(this);
		view.getpPuestoVotacion().getMunicipiosdelete().addActionListener(this);
		view.getpPuestoVotacion().getDepartamentosadd().addActionListener(this);
		view.getpPuestoVotacion().getMunicipiosadd().addActionListener(this);

		// listeners listar Ciudadanos
		view.getlCiudadano().getValidarCedula().addActionListener(this);
		view.getlCiudadano().getValidarinfogeneral().addActionListener(this);
		view.getlCiudadano().getDepartamentos().addActionListener(this);
		view.getlCiudadano().getMunicipios().addActionListener(this);
		view.getlCiudadano().getPuestoVotacion().addActionListener(this);
		view.getlCiudadano().getLocalizacion().addActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {

		// ACCIÓN BOTÓN CIUDADANOS
		if (evento.getSource() == view.getpPrincipal().getbCiudadanos()) {
			view.getpCiudadano().setVisible(true);
			// carga de combobox departamentos en frame AgregarCiudadano
			String validaciondepartamentos = "1";
			for (int i = 0; i < puestosDeVotacion.size(); i++) {
				String[] divisiones = puestosDeVotacion.get(i).split(";");
				String departamentos = divisiones[0];
				if (!validaciondepartamentos.equalsIgnoreCase(departamentos)) {
					view.getpAgregarModificar().getDepartamentos().addItem(departamentos);
				}
				validaciondepartamentos = departamentos;
			}
		}

		// ACCIÓN BOTÓN ESTADÍSTICAS
		if (evento.getSource() == view.getpPrincipal().getbEstadisticas()) {
			view.getpEstadisticas().setVisible(true);
			view.getpEstadisticas().reestablecerValores();
			// carga de combobox departamentos en frame estadisticas
			String validaciondepartamentos = "1";
			for (int i = 0; i < puestosDeVotacion.size(); i++) {
				String[] divisiones = puestosDeVotacion.get(i).split(";");
				String departamentos = divisiones[0];
				if (!validaciondepartamentos.equalsIgnoreCase(departamentos)) {
					view.getpEstadisticas().getDepartamentos().addItem(departamentos);
				}
				validaciondepartamentos = departamentos;
			}
		}

		// ACCIÓN BOTÓN PUESTO DE VOTACIÓN
		if (evento.getSource() == view.getpPrincipal().getbPuestoVotacion()) {
			view.getpPuestoVotacion().setVisible(true);
			view.getpPuestoVotacion().reestablecerValores();
			// carga de combobox departamentos en frame puesto de votación
			String validaciondepartamentos = "1";
			for (int i = 0; i < puestosDeVotacion.size(); i++) {
				String[] divisiones = puestosDeVotacion.get(i).split(";");
				String departamentos = divisiones[0];
				if (!validaciondepartamentos.equalsIgnoreCase(departamentos)) {
					view.getpPuestoVotacion().getDepartamentosadd().addItem(departamentos);
					view.getpPuestoVotacion().getDepartamentosdelete().addItem(departamentos);
				}
				validaciondepartamentos = departamentos;
			}

		}

		// ACCIÓN BOTÓN GRÁFICAS
		if (evento.getSource() == view.getpEstadisticas().getGraficas()) {
			view.getpGraficas().setVisible(true);
		}

		// ACCIÓN BOTÓN AGREGAR CIUDADANO
		if (evento.getSource() == view.getpCiudadano().getAgregarCiudadano()) {
			view.getpAgregarModificar().setVisible(true);
			view.getpAgregarModificar().getAgregarCiudadano().setVisible(true);
			view.getpAgregarModificar().getModificarCiudadano().setVisible(false);
			view.getpAgregarModificar().reestablecerValores();
		}

		// ACCIÓN BOTÓN MODIFICAR CIUDADANO
		if (evento.getSource() == view.getpCiudadano().getModificarCiudadano()) {
			try {
				Ciudadano ciudadanoamodificar;
				String numcedula, nombre1, nombre2, apellido1, apellido2, lugardenacimiento, genero,
						lugarexpedicioncedula, puestovotacionasignado;
				Date fechanacimiento, fechaexpedicion;

				String modificar = view.mostrarMensajes("MODIFICAR");

				ciudadanoamodificar = ciudadanodao.buscarCiudadano(modificar, cedulasInscritas);

				numcedula = ciudadanoamodificar.getNumerocedula();
				nombre1 = ciudadanoamodificar.getNombre1();
				nombre2 = ciudadanoamodificar.getNombre2();
				apellido1 = ciudadanoamodificar.getApellido1();
				apellido2 = ciudadanoamodificar.getApellido2();
				lugardenacimiento = ciudadanoamodificar.getLugardenacimiento();
				genero = ciudadanoamodificar.getGenero();
				lugarexpedicioncedula = ciudadanoamodificar.getLugarexpedicioncedula();
				fechanacimiento = ciudadanoamodificar.getFechanacimiento();
				fechaexpedicion = ciudadanoamodificar.getFechaexpedicion();
				puestovotacionasignado = ciudadanoamodificar.getPuestovotacionasignado();

				String[] comboboxes = puestovotacionasignado.split(";");
				String departamentos = comboboxes[0];
				String municipios = comboboxes[1];
				String pdevotacion1 = comboboxes[2];
				String pdevotacion2 = comboboxes[3];
				System.out.println(departamentos+municipios+pdevotacion1+pdevotacion2);

				String fechanac = String.valueOf(fechanacimiento);
				String fechaexp = String.valueOf(fechaexpedicion);

				view.getpAgregarModificar().getCedula().setText(numcedula);
				view.getpAgregarModificar().getCedula().setEnabled(false);
				view.getpAgregarModificar().getNombre1().setText(nombre1);
				view.getpAgregarModificar().getNombre2().setText(nombre2);
				view.getpAgregarModificar().getApellido1().setText(apellido1);
				view.getpAgregarModificar().getApellido2().setText(apellido2);
				view.getpAgregarModificar().getlNacimiento().setText(lugardenacimiento);
				view.getpAgregarModificar().getSexo().setText(genero);
				view.getpAgregarModificar().getLexpedicion().setText(lugarexpedicioncedula);
				view.getpAgregarModificar().getfNacimiento().setText(fechanac);
				view.getpAgregarModificar().getFexpedicion().setText(fechaexp);
				view.getpAgregarModificar().getDepartamentos().setSelectedItem(departamentos);
				view.getpAgregarModificar().getMunicipios().setSelectedItem(municipios);
				view.getpAgregarModificar().getPuestoVotacion().setSelectedItem(pdevotacion1+";"+pdevotacion2);
				view.getpAgregarModificar().setVisible(true);
				view.getpAgregarModificar().getAgregarCiudadano().setVisible(false);
				view.getpAgregarModificar().getModificarCiudadano().setVisible(true);

			} catch (NullPointerException e) {
				view.mostrarMensajes("NO_EXISTE");
			}

		}

		// ACCIÓN BOTÓN INFORMACIÓN
		if (evento.getSource() == view.getpCiudadano().getMostrarInformacionCiudadano()) {
			view.getlCiudadano().setVisible(true);
			String validaciondepartamentos = "1";
			for (int i = 0; i < puestosDeVotacion.size(); i++) {
				String[] divisiones = puestosDeVotacion.get(i).split(";");
				String departamentos = divisiones[0];
				if (!validaciondepartamentos.equalsIgnoreCase(departamentos)) {
					view.getlCiudadano().getDepartamentos().addItem(departamentos);
				}
				validaciondepartamentos = departamentos;
			}
		}

		// ACCIÓN BOTÓN ELIMINAR CIUDADANO
		if (evento.getSource() == view.getpCiudadano().getEliminarCiudadano()) {
			String cedula = JOptionPane.showInputDialog("DIGITE LA CEDULA DEL CIUDADANO QUE DESEA ELIMINAR.");
			boolean existe = false;
			for (int i = 0; i < cedulasInscritas.size(); i++) {
				if (cedulasInscritas.get(i).getNumerocedula().equals(cedula)) {
					existe = true;
				}
			}
			if (existe == true) {
				ciudadanodao.eliminarCiudadano(cedula, cedulasInscritas);
				view.mostrarMensajes("ELIMINAR_TRUE");
			} else {
				view.mostrarMensajes("ELIMINAR_FALSE");
			}

		}

		// agrega combobox y puesto de votación al frame estadisticas, se pone en un
		// Try-Catch ya que es el primero
		// Que inicializa y si no se pone arrojaría un null pointer Exception

		String[] depar = registraduria.mostrardepartamentos(puestosDeVotacion);
		String validacionmunicipiosestadisticas = "1";
		String validacionmunicipios1 = "1";
		String validacionmunicipios2 = "1";
		String validacionmunicipiosAgregarCiudadano = "1";
		String validacionmunicipiosListarCiudadano = "1";

		// ACCIÓN COMBOBOX DEPARTAMENTOS FRAME ESTADÍSTICAS
		if (evento.getSource() == view.getpEstadisticas().getDepartamentos()) {
			view.getpEstadisticas().getMunicipios().removeAllItems();
		}
		// ACCIÓN COMBOBOX MUNICIPIOS FRAME ESTADÍSTICAS
		if (evento.getSource() == view.getpEstadisticas().getMunicipios()) {
			view.getpEstadisticas().getPuestovotacion().removeAllItems();

		}

		for (int k = 0; k < 35; k++) {
			try {
				
				// ACCIÓN AL SELECCIONAR ITEM COMBOBOX DEPARTAMENTOS FRAME ESTADÍSTICAS
				if (view.getpEstadisticas().getDepartamentos().getSelectedItem().equals(depar[k])) {
					for (int i = 0; i < puestosDeVotacion.size(); i++) {
						String[] Depar = puestosDeVotacion.get(i).split(";");
						String cortar = Depar[0];
						if (cortar.contains(depar[k])) {
							String[] divisiones = puestosDeVotacion.get(i).split(";");
							String municipios = divisiones[1];
							String puesto1 = divisiones[2];
							String puesto2 = divisiones[3];
							
							if (!validacionmunicipiosestadisticas.equalsIgnoreCase(municipios)) {
								view.getpEstadisticas().getMunicipios().addItem(municipios);
							}
							
							validacionmunicipiosestadisticas = municipios;

							if (view.getpEstadisticas().getMunicipios().getSelectedItem().equals(municipios)) {
								view.getpEstadisticas().getPuestovotacion().addItem(puesto1 +";"+ puesto2);
							}
						}
					}
				}
				
			} catch (Exception e) {

			}

		}

		// ACCIÓN COMBOBOX DEPARTAMENTOSADD FRAME PUESTOVOTACIÓN
		if (evento.getSource() == view.getpPuestoVotacion().getDepartamentosadd()) {
			view.getpPuestoVotacion().getMunicipiosadd().removeAllItems();
		}
		// ACCIÓN COMBOBOX DEPARTAMENTOSDELETE FRAME PUESTO VOTACIÓN
		if (evento.getSource() == view.getpPuestoVotacion().getDepartamentosdelete()) {
			view.getpPuestoVotacion().getMunicipiosdelete().removeAllItems();
		}
		// ACCIÓN COMBOBOX MUNICIPIOS DELETE FRAME PUESTO VOTACIÓN
		if (evento.getSource() == view.getpPuestoVotacion().getMunicipiosdelete()) {
			view.getpPuestoVotacion().getPuestovotaciondelete().removeAllItems();
		}

		// agrega combobox de puesto de votación al frame puestovotación

		for (int k = 0; k < 35; k++) {
			// ACCIÓN AL SELECCIONAR ITEM COMBOBOX DEPARTAMENTOSADD FRAME PUESTO VOTACION
			if (view.getpPuestoVotacion().getDepartamentosadd().getSelectedItem().equals(depar[k])) {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					String[] Depar = puestosDeVotacion.get(i).split(";");
					String cortar = Depar[0];
					if (cortar.contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						if (!validacionmunicipios1.equalsIgnoreCase(municipios)) {
							view.getpPuestoVotacion().getMunicipiosadd().addItem(municipios);
						}
						validacionmunicipios1 = municipios;
					}
				}
			}
			// ACCIÓN AL SELECCIONAR ITEM COMBOBOX DEPARTAMENTOSDELETE FRAME PUESTOVOTACIÓN
			if (view.getpPuestoVotacion().getDepartamentosdelete().getSelectedItem().equals(depar[k])) {

				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					String[] Depar = puestosDeVotacion.get(i).split(";");
					String cortar = Depar[0];
					if (cortar.contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipios2.equalsIgnoreCase(municipios)) {
							view.getpPuestoVotacion().getMunicipiosdelete().addItem(municipios);
						}
						validacionmunicipios2 = municipios;
						if (view.getpPuestoVotacion().getMunicipiosdelete().getSelectedItem().equals(municipios)) {
							view.getpPuestoVotacion().getPuestovotaciondelete().addItem(puesto1 +";"+ puesto2);
						}
					}
				}
			}
		}
		// ACCION AGREGAR PUESTO DE VOTACION
		if (evento.getSource() == view.getpPuestoVotacion().getAgregarpuesto()) {
			String departamento = view.getpPuestoVotacion().getDepartamentosadd().getSelectedItem().toString();
			String municipio = view.getpPuestoVotacion().getMunicipiosadd().getSelectedItem().toString();
			String nombrePuesto = view.getpPuestoVotacion().getNombrepuesto().getText();
			String direccionPuesto = view.getpPuestoVotacion().getDireccionpuesto().getText();
			boolean existe = false;
			if (departamento.equals("SELECCIONE") || municipio.equals("SELECCIONE") || nombrePuesto.isEmpty()
					|| direccionPuesto.isEmpty()) {
				view.mostrarMensajes("AGREGARPUESTO_BLANCO");
			} else if (existe == false) {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					if (puestosDeVotacion.get(i)
							.equals(departamento + ";" + municipio + ";" + nombrePuesto + ";" + direccionPuesto)) {
						view.mostrarMensajes("AGREGARPUESTO_FALSE");
						i = puestosDeVotacion.size();
						existe = true;
					}
				}

			} else if (existe == false) {
				puestosDeVotacion.add(departamento + ";" + municipio + ";" + nombrePuesto + ";" + direccionPuesto);
				view.mostrarMensajes("AGREGARPUESTO_TRUE");
			}

		}
		// ACCION ELIMINAR PUESTO DE VOTACIÓN
		if (evento.getSource() == view.getpPuestoVotacion().getEliminarpuesto()) {
			String departamento = view.getpPuestoVotacion().getDepartamentosdelete().getSelectedItem().toString();
			String municipio = view.getpPuestoVotacion().getMunicipiosdelete().getSelectedItem().toString();
			String nombrePuesto = view.getpPuestoVotacion().getPuestovotaciondelete().getSelectedItem().toString();
			
			if (departamento.equals("SELECCIONE") || municipio.equals("SELECCIONE") || nombrePuesto.isEmpty()) {
				view.mostrarMensajes("ELIMINARPUESTO_BLANCO");
			} else {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					//System.out.println(puestosDeVotacion.get(i));
					if (puestosDeVotacion.get(i).equals(departamento + ";" + municipio + ";" + nombrePuesto+ ";")) {
						view.mostrarMensajes("ELIMINARPUESTO_TRUE");
						puestosDeVotacion.remove(i);
						i = puestosDeVotacion.size();
					}
				}

			}

		}

		// ACCIÓN COMBOBOX DEPARTAMENTOS FRAME AGREGAR O MODIFICAR
		if (evento.getSource() == view.getpAgregarModificar().getDepartamentos()) {
			view.getpAgregarModificar().getMunicipios().removeAllItems();
		}
		// ACCIÓN COMBOBOX MUNICIPIOS FRAME AGREGAR O MODIFICAR
		if (evento.getSource() == view.getpAgregarModificar().getMunicipios()) {
			view.getpAgregarModificar().getPuestoVotacion().removeAllItems();
		}

		// agrega combobox y puesto de votación al frame AgregarCiudadano

		for (int k = 0; k < 35; k++) {
			// ACCIÓN AL SELECCIONAR ITEM COMBOBOX DEPARTAMENTOS FRAME AGREGAR O MODIFICAR
			if (view.getpAgregarModificar().getDepartamentos().getSelectedItem().equals(depar[k])) {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					String[] Depar = puestosDeVotacion.get(i).split(";");
					String cortar = Depar[0];
					if (cortar.contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipiosAgregarCiudadano.equalsIgnoreCase(municipios)) {
							view.getpAgregarModificar().getMunicipios().addItem(municipios);
						}
						validacionmunicipiosAgregarCiudadano = municipios;

						if (view.getpAgregarModificar().getMunicipios().getSelectedItem().equals(municipios)) {
							view.getpAgregarModificar().getPuestoVotacion().addItem(puesto1 +";"+ puesto2);
						}
					}
				}
			}
		}

		// modificar combo box de listar Ciudadanos

		// ACCIÓN COMBOBOX DEPARTAMENTOS FRAME LISTAR CIUDADANOS
		if (evento.getSource() == view.getlCiudadano().getDepartamentos()) {
			view.getlCiudadano().getMunicipios().removeAllItems();
		}
		// ACCIÓN COMBOBOX MUNICIPIOS FRAME LISTAR CIUDADANOS
		if (evento.getSource() == view.getlCiudadano().getMunicipios()) {
			view.getlCiudadano().getPuestoVotacion().removeAllItems();
		}
		for (int k = 0; k < 35; k++) {
			// ACCIÓN AL SELECCIONAR ITEM COMBOBOX DEPARTAMENTOS FRAME LISTAR CIUDADANOS
			if (view.getlCiudadano().getDepartamentos().getSelectedItem().equals(depar[k])) {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					String[] Depar = puestosDeVotacion.get(i).split(";");
					String cortar = Depar[0];
					if (cortar.contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipiosListarCiudadano.equalsIgnoreCase(municipios)) {
							view.getlCiudadano().getMunicipios().addItem(municipios);
						}
						validacionmunicipiosListarCiudadano = municipios;
						if (view.getlCiudadano().getMunicipios().getSelectedItem().equals(municipios)) {
							view.getlCiudadano().getPuestoVotacion().addItem(puesto1+";"+puesto2);
						}
					}
				}
			}
		}

		if (evento.getSource() == view.getpAgregarModificar().getAgregarCiudadano()) {
			Ciudadano nuevo;
			String numcedula = view.getpAgregarModificar().getCedula().getText();
			String nombre1 = view.getpAgregarModificar().getNombre1().getText();
			String nombre2 = view.getpAgregarModificar().getNombre2().getText();
			String apellido1 = view.getpAgregarModificar().getApellido1().getText();
			String apellido2 = view.getpAgregarModificar().getApellido2().getText();
			String lugardenacimiento = view.getpAgregarModificar().getlNacimiento().getText();
			String genero = view.getpAgregarModificar().getSexo().getText();
			String lugarexpedicioncedula = view.getpAgregarModificar().getLexpedicion().getText();
			String fechanacimiento = view.getpAgregarModificar().getfNacimiento().getText();
			String fechaexpedicion = view.getpAgregarModificar().getFexpedicion().getText();
			String departamento = (String) view.getpAgregarModificar().getDepartamentos().getSelectedItem();
			String municipios = (String) view.getpAgregarModificar().getMunicipios().getSelectedItem();
			String pvotacion = (String) view.getpAgregarModificar().getPuestoVotacion().getSelectedItem();
			String puestovotacionasignado = departamento + ";" + municipios + ";" + pvotacion;
			boolean verificacion = true;
			if (numcedula.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty()
					|| apellido2.isEmpty() || lugardenacimiento.isEmpty() || genero.isEmpty()
					|| lugarexpedicioncedula.isEmpty() || fechaexpedicion.isEmpty() || fechanacimiento.isEmpty()
					|| puestovotacionasignado.isEmpty()) {
				view.mostrarMensajes("DEBE_LLENAR_CAMPOS");

			} else {
				for (int i = 0; i < cedulasInscritas.size(); i++) {

					if (cedulasInscritas.get(i).getNumerocedula().equalsIgnoreCase(numcedula)) {
						verificacion = false;
					}

				}
				if (verificacion == true) {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNac = null;
					Date fechaExp = null;
					try {
						fechaNac = formato.parse(fechanacimiento);
					} catch (ParseException e) {

						e.printStackTrace();
					}
					try {
						fechaExp = formato.parse(fechaexpedicion);
					} catch (ParseException e) {

						e.printStackTrace();
					}
					nuevo = new Ciudadano(numcedula, nombre1, nombre2, apellido1, apellido2, lugardenacimiento, genero,
							lugarexpedicioncedula, fechaNac, fechaExp, puestovotacionasignado);

					ciudadanodao.agregarCiudadano(numcedula, nuevo, cedulasInscritas);
					view.mostrarMensajes("CREAR_TRUE");
				} else {
					view.mostrarMensajes("CREAR_FALSE");
				}

			}

		}
		
		
		if(evento.getSource()==view.getpEstadisticas().getLocalizacion())
		{
			if(view.getpEstadisticas().getLocalizacion().getSelectedItem().equals("PAIS"))
			{
				view.getpEstadisticas().getDepartamentos().setVisible(false);
				view.getpEstadisticas().getMunicipios().setVisible(false);
				view.getpEstadisticas().getPuestovotacion().setVisible(false);
			}
			if(view.getpEstadisticas().getLocalizacion().getSelectedItem().equals("DEPARTAMENTOS"))
			{
				view.getpEstadisticas().getDepartamentos().setVisible(true);
				view.getpEstadisticas().getMunicipios().setVisible(false);
				view.getpEstadisticas().getPuestovotacion().setVisible(false);
			}
			if(view.getpEstadisticas().getLocalizacion().getSelectedItem().equals("MUNICIPIOS"))
			{
				view.getpEstadisticas().getDepartamentos().setVisible(true);
				view.getpEstadisticas().getMunicipios().setVisible(true);
				view.getpEstadisticas().getPuestovotacion().setVisible(false);
			}
			if(view.getpEstadisticas().getLocalizacion().getSelectedItem().equals("PUESTOS DE VOTACIÓN"))
			{
				view.getpEstadisticas().getDepartamentos().setVisible(true);
				view.getpEstadisticas().getMunicipios().setVisible(true);
				view.getpEstadisticas().getPuestovotacion().setVisible(true);
			}
			
		}
		
		
		
		//AGREGA ESTADÍSTICAS AL PANEL DE ESTADÍSTICAS Y A LAS GRÁFICAS
		if(evento.getSource()==view.getpEstadisticas().getMostrar())
		{
			
			String localizacion = (String) view.getpEstadisticas().getLocalizacion().getSelectedItem();
			
			if(localizacion.equalsIgnoreCase("PAIS"))
			{
				int r1 = registraduria.calcularEstadisticasDeEdad(localizacion,"","1",cedulasInscritas);
				int r2 = registraduria.calcularEstadisticasDeEdad(localizacion,"","2",cedulasInscritas);
				int r3 = registraduria.calcularEstadisticasDeEdad(localizacion,"","3",cedulasInscritas);
				int r4 = registraduria.calcularEstadisticasDeEdad(localizacion,"","4",cedulasInscritas);
				int r5 = registraduria.calcularEstadisticasDeEdad(localizacion,"","5",cedulasInscritas);
				int r6 = registraduria.calcularEstadisticasDeEdad(localizacion,"","6",cedulasInscritas);
				
				int t = r1+r2+r3+r4+r5+r6;
				
				if(t==0)
				{
					view.mostrarMensajes("SIN_ESTADISTICAS");
				}
				else {
				String total = String.valueOf(t);
				String rango1 = String.valueOf(r1);
				String rango2 = String.valueOf(r2);
				String rango3 = String.valueOf(r3);
				String rango4 = String.valueOf(r4);
				String rango5 = String.valueOf(r5);
				String rango6 = String.valueOf(r6);
				
				view.getpEstadisticas().getNumInscritos().setText(total);
				view.getpEstadisticas().getRango1().setText(rango1);
				view.getpEstadisticas().getRango2().setText(rango2);
				view.getpEstadisticas().getRango3().setText(rango3);
				view.getpEstadisticas().getRango4().setText(rango4);
				view.getpEstadisticas().getRango5().setText(rango5);
				view.getpEstadisticas().getRango6().setText(rango6);
				
				double[] genero = registraduria.estadisticasGeneroPais(cedulasInscritas);
				
				double femenino = genero[0];
				double masculino = genero[1];
				
				String masc = String.valueOf(masculino);
				String fem = String.valueOf(femenino);
				
				view.getpEstadisticas().getPorcHombres().setText(masc);
				view.getpEstadisticas().getPorcMujeres().setText(fem);
				
				view.getpGraficas().graficasTorta(femenino, masculino, r1, r2, r3, r4, r5, r6);
				view.getpGraficas().graficasBarras(femenino, masculino, r1, r2, r3, r4, r5, r6);
				}
			}
			
			if(localizacion.equalsIgnoreCase("DEPARTAMENTOS"))
			{
				String departamento = (String) view.getpEstadisticas().getDepartamentos().getSelectedItem();
				int r1 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"1",cedulasInscritas);
				int r2 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"2",cedulasInscritas);
				int r3 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"3",cedulasInscritas);
				int r4 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"4",cedulasInscritas);
				int r5 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"5",cedulasInscritas);
				int r6 = registraduria.calcularEstadisticasDeEdad(localizacion,departamento,"6",cedulasInscritas);
				
				int t = r1+r2+r3+r4+r5+r6;
				if(t==0)
				{
					view.mostrarMensajes("SIN_ESTADISTICAS");
				}
				else {
				String total = String.valueOf(t);
				String rango1 = String.valueOf(r1);
				String rango2 = String.valueOf(r2);
				String rango3 = String.valueOf(r3);
				String rango4 = String.valueOf(r4);
				String rango5 = String.valueOf(r5);
				String rango6 = String.valueOf(r6);
				
				view.getpEstadisticas().getNumInscritos().setText(total);
				view.getpEstadisticas().getRango1().setText(rango1);
				view.getpEstadisticas().getRango2().setText(rango2);
				view.getpEstadisticas().getRango3().setText(rango3);
				view.getpEstadisticas().getRango4().setText(rango4);
				view.getpEstadisticas().getRango5().setText(rango5);
				view.getpEstadisticas().getRango6().setText(rango6);
				
				double[] genero = registraduria.estadisticasGeneroDepartamento(departamento,cedulasInscritas);
				double femenino = genero[0];
				double masculino = genero[1];
				
				String masc = String.valueOf(masculino);
				String fem = String.valueOf(femenino);
				
				view.getpEstadisticas().getPorcHombres().setText(masc);
				view.getpEstadisticas().getPorcMujeres().setText(fem);
				
				view.getpGraficas().graficasTorta(femenino, masculino, r1, r2, r3, r4, r5, r6);
				view.getpGraficas().graficasBarras(femenino, masculino, r1, r2, r3, r4, r5, r6);
				}
			}
		
			if(localizacion.equalsIgnoreCase("MUNICIPIOS"))
			{
				String municipios = (String) view.getpEstadisticas().getMunicipios().getSelectedItem();
				int r1 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"1",cedulasInscritas);
				int r2 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"2",cedulasInscritas);
				int r3 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"3",cedulasInscritas);
				int r4 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"4",cedulasInscritas);
				int r5 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"5",cedulasInscritas);
				int r6 = registraduria.calcularEstadisticasDeEdad(localizacion,municipios,"6",cedulasInscritas);
				
				int t = r1+r2+r3+r4+r5+r6;
				
				if(t==0)
				{
					view.mostrarMensajes("SIN_ESTADISTICAS");
				}
				else
				{
				String total = String.valueOf(t);
				String rango1 = String.valueOf(r1);
				String rango2 = String.valueOf(r2);
				String rango3 = String.valueOf(r3);
				String rango4 = String.valueOf(r4);
				String rango5 = String.valueOf(r5);
				String rango6 = String.valueOf(r6);
				
				view.getpEstadisticas().getNumInscritos().setText(total);
				view.getpEstadisticas().getRango1().setText(rango1);
				view.getpEstadisticas().getRango2().setText(rango2);
				view.getpEstadisticas().getRango3().setText(rango3);
				view.getpEstadisticas().getRango4().setText(rango4);
				view.getpEstadisticas().getRango5().setText(rango5);
				view.getpEstadisticas().getRango6().setText(rango6);
				
				double[] genero = registraduria.estadisticasGeneroMunicipio(municipios,cedulasInscritas);
				double femenino = genero[0];
				double masculino = genero[1];
				
				String masc = String.valueOf(masculino);
				String fem = String.valueOf(femenino);
				
				view.getpEstadisticas().getPorcHombres().setText(masc);
				view.getpEstadisticas().getPorcMujeres().setText(fem);
				
				view.getpGraficas().graficasTorta(femenino, masculino, r1, r2, r3, r4, r5, r6);
				view.getpGraficas().graficasBarras(femenino, masculino, r1, r2, r3, r4, r5, r6);
				}
			}
			if(localizacion.equalsIgnoreCase("PUESTOS DE VOTACIÓN"))
			{
				String pVotacion = (String) view.getpEstadisticas().getPuestovotacion().getSelectedItem();
				int r1 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"1",cedulasInscritas);
				int r2 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"2",cedulasInscritas);
				int r3 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"3",cedulasInscritas);
				int r4 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"4",cedulasInscritas);
				int r5 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"5",cedulasInscritas);
				int r6 = registraduria.calcularEstadisticasDeEdad(localizacion,pVotacion,"6",cedulasInscritas);
				
				int t = r1+r2+r3+r4+r5+r6;
				
				if(t==0)
				{
					view.mostrarMensajes("SIN_ESTADISTICAS");
				}
				else
				{
				String total = String.valueOf(t);
				String rango1 = String.valueOf(r1);
				String rango2 = String.valueOf(r2);
				String rango3 = String.valueOf(r3);
				String rango4 = String.valueOf(r4);
				String rango5 = String.valueOf(r5);
				String rango6 = String.valueOf(r6);
				
				view.getpEstadisticas().getNumInscritos().setText(total);
				view.getpEstadisticas().getRango1().setText(rango1);
				view.getpEstadisticas().getRango2().setText(rango2);
				view.getpEstadisticas().getRango3().setText(rango3);
				view.getpEstadisticas().getRango4().setText(rango4);
				view.getpEstadisticas().getRango5().setText(rango5);
				view.getpEstadisticas().getRango6().setText(rango6);
				
				double[] genero = registraduria.estadisticasGeneroPuesto(pVotacion,cedulasInscritas);
				double femenino = genero[0];
				double masculino = genero[1];
				
				String masc = String.valueOf(masculino);
				String fem = String.valueOf(femenino);
				
				view.getpEstadisticas().getPorcHombres().setText(masc);
				view.getpEstadisticas().getPorcMujeres().setText(fem);
				
				view.getpGraficas().graficasTorta(femenino, masculino, r1, r2, r3, r4, r5, r6);
				view.getpGraficas().graficasBarras(femenino, masculino, r1, r2, r3, r4, r5, r6);
				}
			}
		}
		
		
		//AGREGA EL LISTADO DE CIUDADANO INDIVIDUALMENTE INSCRITOS AL PANEL LISTAR CIUDADANOS
		if(evento.getSource()==view.getlCiudadano().getValidarCedula())
		{
			String validarcedula = view.getlCiudadano().getCedula().getText();
			
			Ciudadano ciudadano = ciudadanodao.buscarCiudadano(validarcedula, cedulasInscritas);
			
			if(ciudadano==null)
			{
				view.mostrarMensajes("NO_EXISTE");
			}
			else {
			String cedula = ciudadano.getNumerocedula();
			String nombre1 = ciudadano.getNombre1();
			String nombre2 = ciudadano.getNombre2();
			String apellido1 = ciudadano.getApellido1();
			String apellido2 = ciudadano.getApellido2();
			String lNacimiento = ciudadano.getLugardenacimiento();
			String genero = ciudadano.getGenero();
			String lexpedicion = ciudadano.getLugarexpedicioncedula();
			Date fNacimiento = ciudadano.getFechanacimiento();
			Date fExpedicion = ciudadano.getFechaexpedicion();
			String pVotacion = ciudadano.getPuestovotacionasignado();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaNac = sdf.format(fNacimiento);
			String fechaExp = sdf.format(fExpedicion);
			
			view.getlCiudadano().getInfoCiudadano().setValueAt(cedula.toUpperCase(), 0, 0);
			view.getlCiudadano().getInfoCiudadano().setValueAt(apellido1.toUpperCase(), 0, 1);
			view.getlCiudadano().getInfoCiudadano().setValueAt(apellido2.toUpperCase(), 0, 2);
			view.getlCiudadano().getInfoCiudadano().setValueAt(nombre1.toUpperCase(), 0, 3);
			view.getlCiudadano().getInfoCiudadano().setValueAt(nombre2.toUpperCase(), 0, 4);
			view.getlCiudadano().getInfoCiudadano().setValueAt(fechaNac.toUpperCase(), 0, 5);
			view.getlCiudadano().getInfoCiudadano().setValueAt(lNacimiento.toUpperCase(), 0, 6);
			view.getlCiudadano().getInfoCiudadano().setValueAt(fechaExp.toUpperCase(), 0, 7);
			view.getlCiudadano().getInfoCiudadano().setValueAt(lexpedicion.toUpperCase(), 0, 8);
			view.getlCiudadano().getInfoCiudadano().setValueAt(genero.toUpperCase(), 0, 9);
			view.getlCiudadano().getInfoCiudadano().setValueAt(pVotacion.toUpperCase(), 0, 10);
			}
		}
		
		
		
		if(evento.getSource()==view.getlCiudadano().getLocalizacion())
		{
			if(view.getlCiudadano().getLocalizacion().getSelectedItem().equals("PAIS"))
			{
				view.getlCiudadano().getDepartamentos().setVisible(false);
				view.getlCiudadano().getMunicipios().setVisible(false);
				view.getlCiudadano().getPuestoVotacion().setVisible(false);
				
			}
			if(view.getlCiudadano().getLocalizacion().getSelectedItem().equals("DEPARTAMENTOS"))
			{
				view.getlCiudadano().getDepartamentos().setVisible(true);
				view.getlCiudadano().getMunicipios().setVisible(false);
				view.getlCiudadano().getPuestoVotacion().setVisible(false);
			}
			if(view.getlCiudadano().getLocalizacion().getSelectedItem().equals("MUNICIPIOS"))
			{
				view.getlCiudadano().getDepartamentos().setVisible(true);
				view.getlCiudadano().getMunicipios().setVisible(true);
				view.getlCiudadano().getPuestoVotacion().setVisible(false);
			}
			if(view.getlCiudadano().getLocalizacion().getSelectedItem().equals("PUESTOS DE VOTACIÓN"))
			{
				view.getlCiudadano().getDepartamentos().setVisible(true);
				view.getlCiudadano().getMunicipios().setVisible(true);
				view.getlCiudadano().getPuestoVotacion().setVisible(true);
			}
		}
		
		
		//AGREGA LA INFORMACIÓN GENERAL DE TODOS LOS INSCRITOS 
		
		if(evento.getSource()==view.getlCiudadano().getValidarinfogeneral())
		{
			String validacion = (String) view.getlCiudadano().getLocalizacion().getSelectedItem();
			
			if(validacion.equalsIgnoreCase("PAIS"))
			{	
				
				
				for(int i = 0; i<cedulasInscritas.size();i++)
				{
					Date fNacimiento = cedulasInscritas.get(i).getFechanacimiento();
					Date fExpedicion = cedulasInscritas.get(i).getFechaexpedicion();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					String fechaNac = sdf.format(fNacimiento);
					String fechaExp = sdf.format(fExpedicion);
					
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNumerocedula().toUpperCase(), i, 0);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido1().toUpperCase(), i, 1);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido2().toUpperCase(), i, 2);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre1().toUpperCase(), i, 3);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre2().toUpperCase(), i, 4);
					view.getlCiudadano().getInfoGeneral().setValueAt(fechaNac.toUpperCase(), i, 5);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugardenacimiento().toUpperCase(), i, 6);
					view.getlCiudadano().getInfoGeneral().setValueAt(fechaExp.toUpperCase(), i, 7);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugarexpedicioncedula().toUpperCase(), i, 8);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getGenero().toUpperCase(), i, 9);
					view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getPuestovotacionasignado().toUpperCase(), i, 10);
					
				}
			}
			
			if(validacion.equalsIgnoreCase("DEPARTAMENTOS"))
			{
				String validarDepartamento = (String) view.getlCiudadano().getDepartamentos().getSelectedItem();
				int posicion = 0;
				for(int i = 0; i<cedulasInscritas.size();i++)
				{
					String[] dividir = cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
					String departamento = dividir[0];
					
				if(departamento.equalsIgnoreCase(validarDepartamento))
				{
				Date fNacimiento = cedulasInscritas.get(i).getFechanacimiento();
				Date fExpedicion = cedulasInscritas.get(i).getFechaexpedicion();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String fechaNac = sdf.format(fNacimiento);
				String fechaExp = sdf.format(fExpedicion);
				
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNumerocedula().toUpperCase(),posicion, 0);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido1().toUpperCase(),posicion, 1);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido2().toUpperCase(),posicion, 2);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre1().toUpperCase(),posicion, 3);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre2().toUpperCase(),posicion, 4);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaNac.toUpperCase(),posicion, 5);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugardenacimiento().toUpperCase(),posicion, 6);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaExp.toUpperCase(),posicion, 7);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugarexpedicioncedula().toUpperCase(),posicion, 8);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getGenero().toUpperCase(),posicion, 9);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getPuestovotacionasignado().toUpperCase(),posicion, 10);
				posicion++;
					}
				}
			}
			if(validacion.equalsIgnoreCase("MUNICIPIOS"))
			{
				String validarMunicipio = (String) view.getlCiudadano().getMunicipios().getSelectedItem();
				int posicion = 0;
				for(int i = 0; i<cedulasInscritas.size();i++)
				{
					String[] dividir = cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
					String municipios = dividir[1];
					
				if(municipios.equalsIgnoreCase(validarMunicipio))
				{
				Date fNacimiento = cedulasInscritas.get(i).getFechanacimiento();
				Date fExpedicion = cedulasInscritas.get(i).getFechaexpedicion();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String fechaNac = sdf.format(fNacimiento);
				String fechaExp = sdf.format(fExpedicion);
				
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNumerocedula().toUpperCase(),posicion, 0);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido1().toUpperCase(),posicion, 1);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido2().toUpperCase(),posicion, 2);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre1().toUpperCase(),posicion, 3);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre2().toUpperCase(),posicion, 4);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaNac.toUpperCase(),posicion, 5);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugardenacimiento().toUpperCase(),posicion, 6);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaExp.toUpperCase(),posicion, 7);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugarexpedicioncedula().toUpperCase(),posicion, 8);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getGenero().toUpperCase(),posicion, 9);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getPuestovotacionasignado().toUpperCase(),posicion, 10);
				posicion++;
					}
				}
			}
			
			if(validacion.equalsIgnoreCase("PUESTOS DE VOTACIÓN"))
			{
				String validarPuestoVotacion = (String) view.getlCiudadano().getPuestoVotacion().getSelectedItem();
				int posicion = 0;
				for(int i = 0; i<cedulasInscritas.size();i++)
				{
					String[] dividir = cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
					String puestodevotacion = dividir[2].concat(";"+dividir[3]);
					
				if(puestodevotacion.equalsIgnoreCase(validarPuestoVotacion))
				{
				Date fNacimiento = cedulasInscritas.get(i).getFechanacimiento();
				Date fExpedicion = cedulasInscritas.get(i).getFechaexpedicion();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String fechaNac = sdf.format(fNacimiento);
				String fechaExp = sdf.format(fExpedicion);
				
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNumerocedula().toUpperCase(),posicion, 0);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido1().toUpperCase(),posicion, 1);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getApellido2().toUpperCase(),posicion, 2);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre1().toUpperCase(),posicion, 3);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getNombre2().toUpperCase(),posicion, 4);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaNac.toUpperCase(),posicion, 5);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugardenacimiento().toUpperCase(),posicion, 6);
				view.getlCiudadano().getInfoGeneral().setValueAt(fechaExp.toUpperCase(),posicion, 7);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getLugarexpedicioncedula().toUpperCase(),posicion, 8);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getGenero().toUpperCase(),posicion, 9);
				view.getlCiudadano().getInfoGeneral().setValueAt(cedulasInscritas.get(i).getPuestovotacionasignado().toUpperCase(),posicion, 10);
				posicion++;
					}
				}
			}
			
			
		}
		

	}

}
