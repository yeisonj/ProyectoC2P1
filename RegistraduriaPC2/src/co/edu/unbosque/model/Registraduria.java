/* Clase que modela una Registraduría donde se hará el manejo de datos de inscripción de cédulas para votación
 */

/**
 * <h1>Modela la Registraduría en su apartado de inscripcion de cédulas para votación</h1>
* Se encarga de modelar todos los atributos y metodos de la registraduría en cédulas para votación
* @version 1.0
* @author Jeisson Jossa, Sebastián Moncaleano, Moisés Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Registraduria implements TransformarDate {
	
	private final File ARCHIVO_USUARIOS = new File("./CedulasInscritas.csv");
	private final File ARCHIVO_PUESTOS_VOTACION = new File("./Puestos_de_votacion.csv");
	private ArrayList <Ciudadano> cedulasInscritas = new ArrayList();
	private ArrayList <String> puestosDeVotacion = new ArrayList();
	
	
	public void guardarTabla() {
	
		try {
			
			ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream("./CedulasInscritas.csv"));
			
			
			wr.writeObject(cedulasInscritas);
			wr.close();
			
			ObjectInputStream re = new ObjectInputStream(new FileInputStream("./CedulasInscritas.csv"));
			 cedulasInscritas =(ArrayList<Ciudadano>) re.readObject();
			 re.close();
			
		}catch(Exception e) {
			
		}
	}
	
	/**
	* Este método agrega un ciudadano a un puesto de votación
	* <b>pre</b> La lista de ciudadanos está inicializada (no es
	null). <br>
	* <b>post</b> Se ha registrado un nuevo ciudadano con los
	datos dados <br>
	* @param cedula Es la cédula del nuevo cidadano. cedula != null,
	cedula != " "
	*/
	public void agregarCiudadano(Ciudadano ciudadanoAInscribir) {
		
		cedulasInscritas.add(ciudadanoAInscribir);
		
		
		
		
	}
	
	
	public void cargarListaPuestosDeVotacion() {
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
		}catch(IOException e) {
			System.out.println("Hubo un error leyendo en el archivo");
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void eliminarCiudadano(String numeroCedula) {
		for(int j= 0;j < cedulasInscritas.size(); j++)  {
			String cc = cedulasInscritas.get(j).getNumeroCedula();
			if(numeroCedula.equalsIgnoreCase(cc)) {
				cedulasInscritas.remove(j);	
			}
		}
	}
	
	public void listarP() {
		System.out.println("________");
		for (int i=0; i<cedulasInscritas.size(); i++) {
			System.out.println(cedulasInscritas.get(i));
			
		}
		
	}
	
	

	@Override
	public int transformarDate(Date f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
