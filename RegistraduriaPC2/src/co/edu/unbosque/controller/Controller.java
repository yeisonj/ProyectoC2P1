package co.edu.unbosque.controller;

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
				String pdevotacion = comboboxes[2];

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
				view.getpAgregarModificar().getPuestoVotacion().setSelectedItem(pdevotacion);
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
						if (puestosDeVotacion.get(i).contains(depar[k])) {
							String[] divisiones = puestosDeVotacion.get(i).split(";");
							String municipios = divisiones[1];
							String puesto1 = divisiones[2];
							String puesto2 = divisiones[3];
							if (!validacionmunicipiosestadisticas.equalsIgnoreCase(municipios)) {
								view.getpEstadisticas().getMunicipios().addItem(municipios);
							}
							validacionmunicipiosestadisticas = municipios;

							if (view.getpEstadisticas().getMunicipios().getSelectedItem().equals(municipios)) {
								view.getpEstadisticas().getPuestovotacion().addItem(puesto1 + puesto2);
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
					if (puestosDeVotacion.get(i).contains(depar[k])) {
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
					if (puestosDeVotacion.get(i).contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipios2.equalsIgnoreCase(municipios)) {
							view.getpPuestoVotacion().getMunicipiosdelete().addItem(municipios);
						}
						validacionmunicipios2 = municipios;
						if (view.getpPuestoVotacion().getMunicipiosdelete().getSelectedItem().equals(municipios)) {
							view.getpPuestoVotacion().getPuestovotaciondelete().addItem(puesto1 + puesto2);
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
		// ACCION ELIMINAR PUESTO DE BOTACION
		if (evento.getSource() == view.getpPuestoVotacion().getEliminarpuesto()) {
			String departamento = view.getpPuestoVotacion().getDepartamentosdelete().getSelectedItem().toString();
			String municipio = view.getpPuestoVotacion().getMunicipiosdelete().getSelectedItem().toString();
			String nombrePuesto = view.getpPuestoVotacion().getPuestovotaciondelete().getSelectedItem().toString();
			
			System.out.println(departamento + ";" + municipio + ";" + nombrePuesto);
			if (departamento.equals("SELECCIONE") || municipio.equals("SELECCIONE") || nombrePuesto.isEmpty()) {
				view.mostrarMensajes("ELIMINARPUESTO_BLANCO");
			} else {
				for (int i = 0; i < puestosDeVotacion.size(); i++) {
					System.out.println(puestosDeVotacion.get(i));
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
					if (puestosDeVotacion.get(i).contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipiosAgregarCiudadano.equalsIgnoreCase(municipios)) {
							view.getpAgregarModificar().getMunicipios().addItem(municipios);
						}
						validacionmunicipiosAgregarCiudadano = municipios;

						if (view.getpAgregarModificar().getMunicipios().getSelectedItem().equals(municipios)) {
							view.getpAgregarModificar().getPuestoVotacion().addItem(puesto1 + puesto2);
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
					if (puestosDeVotacion.get(i).contains(depar[k])) {
						String[] divisiones = puestosDeVotacion.get(i).split(";");
						String municipios = divisiones[1];
						String puesto1 = divisiones[2];
						String puesto2 = divisiones[3];
						if (!validacionmunicipiosListarCiudadano.equalsIgnoreCase(municipios)) {
							view.getlCiudadano().getMunicipios().addItem(municipios);
						}
						validacionmunicipiosListarCiudadano = municipios;
						if (view.getlCiudadano().getMunicipios().getSelectedItem().equals(municipios)) {
							view.getlCiudadano().getPuestoVotacion().addItem(puesto1 + puesto2);
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
			if (numcedula.isEmpty() || nombre1.isEmpty() || nombre2.isEmpty() || apellido1.isEmpty()
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

	}

}
