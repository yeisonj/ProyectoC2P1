package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Ciudadano;

public class CiudadanoDAO {

	private Archivo archivo;

	public CiudadanoDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	// CRUD
	public String mostrarInformacionCiudadano(String numeroCedula,ArrayList <Ciudadano> cedulasInscritas) {
		String showCiu="";
		for(int j= 0;j < cedulasInscritas.size(); j++)  {
			String cc = cedulasInscritas.get(j).getNumerocedula();
			if(numeroCedula.equalsIgnoreCase(cc)) {
				showCiu = cedulasInscritas.get(j).toString();
			}
		}
		return showCiu;
	}

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
