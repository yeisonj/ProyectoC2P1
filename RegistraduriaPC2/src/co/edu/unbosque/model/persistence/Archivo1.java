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



public class Archivo1 {
	
	
	private final File ARCHIVO_USUARIOS = new File("./CedulasInscritas.csv");
	private final File ARCHIVO_PUESTOS_VOTACION = new File("./Puestos_de_votacion.csv");
	
	
	public void guardarBaseDatos(ArrayList <Ciudadano> cedulasInscritas) {
		
		try {
			
			ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream("./CedulasInscritas.csv"));
			wr.writeObject(cedulasInscritas);
			wr.close();
			
			
		}catch(Exception e) {
			System.out.println("no se guardó");
			
		}
	}
	
	public void cargarListaPuestosDeVotacion(ArrayList <String> puestosDeVotacion) {
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
	
	public void cargarBaseDatos(ArrayList <Ciudadano> cedulasInscritas) {
		
		
		if(ARCHIVO_USUARIOS.exists()) {
		try {
		FileInputStream fi = new FileInputStream (ARCHIVO_USUARIOS);
		ObjectInputStream re = new ObjectInputStream(fi);
		
		 cedulasInscritas =(ArrayList<Ciudadano>) re.readObject();
		 re.close();
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null,"Hubo un error leyendo en el archivo");
		}
		}
		
	}
	
	

}