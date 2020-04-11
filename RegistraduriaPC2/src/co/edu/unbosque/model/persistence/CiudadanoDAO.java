package co.edu.unbosque.model.persistence;

import java.io.IOException;

import java.util.ArrayList;

import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Ciudadano;

/**
 * Esta clase contiene todos los métodos relacionados con el manejo de ciudadanos inscritos.
 * @author Sebastián Moncaleano
 */

public class CiudadanoDAO {

	private Archivo archivo;

	public CiudadanoDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	
	/**
	 * Este método retorna un ciudadano que coincida con un número de cédula en específico. 
	 * <b>pre</b> el ArrayList de ciudadanos est� inicializado (no es null). <br>
	 * <b>post</b> Se ha retornado el objeto ciudadano con el número de cedula especificado <br>
	 * @param cedula es el número de indentificación del ciudadano inscrito.
	 * @param cedulasInscritas es el ArrayList de ciudadanos inscritos.
	 * @return se retorna un objeto del tipo ciudadano.
	 */
	
	// CRUD
	public Ciudadano buscarCiudadano(String cedula, ArrayList <Ciudadano> cedulasInscritas) {
		Ciudadano encontrado = null;
		if (!cedulasInscritas.isEmpty()) {
			for (int i = 0; i < cedulasInscritas.size(); i++) {
				if (cedulasInscritas.get(i).getNumerocedula().equals(cedula)) {
					encontrado = cedulasInscritas.get(i);
				}
			}
		}

		return encontrado;
	}
	
	/**
	 * Este método se encarga de eliminar un ciudadano del archivo de persistencia de ciudadanos.
	 * <b>pre</b> el ArrayList de ciudadanos est� inicializado (no es null). <br>
	 * <b>post</b> Se ha eliminado el ciudadano del archivo de ciudadanos<br>
	 * @param cedula es el número de indentificación del ciudadano inscrito.
	 * @param cedulasInscritas es el ArrayList de ciudadanos inscritos.
	 */
	
	public void eliminarCiudadano(String cedula, ArrayList <Ciudadano> cedulasInscritas) {
		try {
			Ciudadano c = buscarCiudadano(cedula, cedulasInscritas);
			cedulasInscritas.remove(c);
			archivo.getArchivo().delete();
			archivo.getArchivo().createNewFile();
			archivo.escribirEnArchivo(cedulasInscritas);
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		
		}
	}

	/**
	 * 
	 * @param numeroCedula es el número de indentificación del ciudadano inscrito.
	 * @param ciudadanoAInscribir es el objeto del ciudadano que se va a inscribir.
	 * @param cedulasInscritas es el ArrayList de ciudadanos inscritos.
	 * @return un boolean true si el ciudadano fue inscrito y false sino lo fue.
	 */
	
	public boolean agregarCiudadano(String numeroCedula, Ciudadano ciudadanoAInscribir, ArrayList <Ciudadano> cedulasInscritas) {
		
		if (buscarCiudadano(numeroCedula, cedulasInscritas) == null) {
			cedulasInscritas.add(ciudadanoAInscribir);
			archivo.escribirEnArchivo(cedulasInscritas);
			return true;
		} else {
			return false;
		}
}

	
	
}
