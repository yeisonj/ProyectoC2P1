package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Ciudadano;

public class Archivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File ARCHIVO_USUARIOS = new File("./CedulasInscritas.csv");
	private final File ARCHIVO_PUESTOS_VOTACION = new File("./Puestos_de_votacion.csv");

	public Archivo() {
		if (ARCHIVO_USUARIOS.exists()) {
			System.out.println("El archivo ya existe");
		} else {
			try {
				ARCHIVO_USUARIOS.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

	public void escribirEnArchivo(ArrayList <Ciudadano> cedulasInscritas) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS));
			salida.writeObject(cedulasInscritas);
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Ciudadano> leerArchivo() {
		ArrayList <Ciudadano> cedulasInscritas= new ArrayList<Ciudadano>();
		if (ARCHIVO_USUARIOS.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS));
				cedulasInscritas = (ArrayList<Ciudadano>) entrada.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cedulasInscritas;
	}

	public ArrayList<String> cargarListaPuestosDeVotacion() {
		ArrayList <String> puestosDeVotacion = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(ARCHIVO_PUESTOS_VOTACION);
			BufferedReader br = new BufferedReader(fr);
			//lectura de la primera linea del archivo
			String lineaLeida = br.readLine();
			//ciclo que lee y recorre cada una de las lineas del archivo que se está leyendo
			
			while(lineaLeida!=null) {
				
				puestosDeVotacion.add(lineaLeida);
				
				
				lineaLeida = br.readLine();
				
				}
			return puestosDeVotacion;
			
		}catch(IOException e) {
			System.out.println("Hubo un error leyendo en el archivo");
			System.out.println(e.getMessage());
		}
		return puestosDeVotacion;
		
	}
	

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public File getArchivo() {
		return ARCHIVO_USUARIOS;
	}

	public void setArchivo(File archivo) {
		this.ARCHIVO_USUARIOS = archivo;
	}
}
