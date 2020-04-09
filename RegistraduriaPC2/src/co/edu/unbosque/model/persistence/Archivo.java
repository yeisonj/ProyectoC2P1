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

/**
 * Esta clase se encarga de hacer el manejo de los archivos de persistencia del proyecto
 * @author Sebastian Moncaleano
 */

public class Archivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File ARCHIVO_USUARIOS = new File("./CedulasInscritas.csv");
	private final File ARCHIVO_PUESTOS_VOTACION = new File("./Puestos_de_votacion.csv");

	/**
	 * Este es el contructor de la clase archivo, este archivo contiene los ciudadanos inscritos.
	 * <b>post</b> Se ha creado el archivo de ciudadanos<br> 
	 */
	
	public Archivo() {
		if (ARCHIVO_USUARIOS.exists()) {
			System.out.println("El archivo ya existe");
		} else {
			try {
				ARCHIVO_USUARIOS.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * Este metodo se encarga de persistir la información de los ciudadanos que han sido inscritos para votar.
	 *  <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha persisitido la informacion de los ciudadanos inscritos <br>
	 * @param cedulasInscritas es el Arraylist que contiene a los ciudadanos inscritos
	 */

	public void escribirEnArchivo(ArrayList <Ciudadano> cedulasInscritas) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS));
			salida.writeObject(cedulasInscritas);
			salida.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * Este método lee el archivo donde se encuentra persistida la informacion y carga la informacion
	 * de los ciudadanos inscritos al arrayList cedulasInscritas
	 *  <b>pre</b> El archivo con la información de los ciudadanos existe no es null <br>
	 * <b>post</b> Se ha cargado la información del archivo de ciudadanos y se ha retornado el arrayList
	 * cedulasInscritas con la información <br>
	 * @return retorna el arrayList con los ciudadanos que hayan sido inscritos
	 */
	
	public ArrayList<Ciudadano> leerArchivo() {
		ArrayList <Ciudadano> cedulasInscritas= new ArrayList<Ciudadano>();
		if (ARCHIVO_USUARIOS.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS));
				cedulasInscritas = (ArrayList<Ciudadano>) entrada.readObject();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		return cedulasInscritas;
	}

	/**
	 * Este método se encarga de cargar la lista de los puestos de votación y los incluye en un Arraylist de Strings.
	 *  <b>pre</b> El archivo de puestos de votacion existe, no es null <br>
	 * <b>post</b> Se han cargado los puestos de votación y retornado en el arrayList de Strings 
	 * puestoDeVotación<br>
	 * @return se retorna el ArrayList puestos de votacion, con todos los puestos de votación cargados.
	 */
	
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
