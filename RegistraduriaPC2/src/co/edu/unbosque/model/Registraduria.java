/* Clase que modela una Registradurï¿½a donde se harï¿½ el manejo de datos de inscripciï¿½n de cï¿½dulas para votaciï¿½n
 */

/**
 * <h1>Modela la Registradurï¿½a en su apartado de inscripcion de cï¿½dulas para votaciï¿½n</h1>
* Se encarga de modelar todos los atributos y metodos de la registradurï¿½a en cï¿½dulas para votaciï¿½n
* @version 1.0
* @author Jeisson Jossa, Sebastiï¿½n Moncaleano, Moisï¿½s Salcedo, Diego Torres | Universidad El Bosque
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

public class Registraduria  {
	
	private final File ARCHIVO_USUARIOS = new File("./CedulasInscritas.csv");
	private final File ARCHIVO_PUESTOS_VOTACION = new File("./Puestos_de_votacion.csv");
	private ArrayList <Ciudadano> cedulasInscritas = new ArrayList();
	private ArrayList <String> puestosDeVotacion = new ArrayList();
	
	public Registraduria() {
		cargarListaPuestosDeVotacion();
	}
	
	
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
	* Este mï¿½todo agrega un ciudadano a un puesto de votaciï¿½n
	* <b>pre</b> La lista de ciudadanos estï¿½ inicializada (no es
	null). <br>
	* <b>post</b> Se ha registrado un nuevo ciudadano con los
	datos dados <br>
	* @param cedula Es la cï¿½dula del nuevo cidadano. cedula != null,
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
			//ciclo que lee y recorre cada una de las lineas del archivo que se estï¿½ leyendo
			
			
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
			String cc = cedulasInscritas.get(j).getNumerocedula();
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
	
	
	
	public String mostrarInformacionPuesto(String puesto) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String aux=cedulasInscritas.get(i).getPuestovotacionasignado();
		
			if(aux==puesto) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
	
	
	
	
	
	public String mostrarInformacionMunicipio(String municipio) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[1]==municipio) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
	
	public String mostrarInformacionDepartamento(String departamento) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[0]==departamento) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
	
	public int calcularEstadisticasDeEdad(String rango) {
		int cant =0;
		switch(rango) {
		
		case "1":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}
			}
			break;
			
		case "2":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}
			}
			break;
			
		case "3":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}
			}
			break;
			
		case "4":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}
			}
			break;
			
		case "5":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}
			}
			break;
			
		case "6":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				if(cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}
			}
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Este rango de edad no se encentra entre las estadísticas");
			break;
		
		
		}
		
		return cant;

	}
	
	public String[] mostrarCiudadanosInscritosPuesto(String puesto) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionPuesto(puesto))];
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String aux=cedulasInscritas.get(i).getPuestovotacionasignado();
		
			if(aux==puesto) {
			String auxc= cedulasInscritas.get(i).getNombre1()+" "+cedulasInscritas.get(i).getNombre2()+" "+cedulasInscritas.get(i).getApellido1()+" "+cedulasInscritas.get(i).getApellido2()+" "+cedulasInscritas.get(i).getNumerocedula();
			ciudinscritos[p]=auxc;
			p++;
			}
			
		}
			
			return ciudinscritos;
	}
	
	public String[] mostrarCiudadanosInscritosMunicipio(String municipio) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionMunicipio(municipio))];
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[1]==municipio) {
			String auxc= cedulasInscritas.get(i).getNombre1()+" "+cedulasInscritas.get(i).getNombre2()+" "+cedulasInscritas.get(i).getApellido1()+" "+cedulasInscritas.get(i).getApellido2()+" "+cedulasInscritas.get(i).getNumerocedula();
			ciudinscritos[p]=auxc;
			p++;
			}
			
		}
			
			return ciudinscritos;
	}
	
	
	
	
	public String[] mostrarCiudadanosInscritosDepartamento(String departamento) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionDepartamento(departamento))];
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[0]==departamento) {
			String auxc= cedulasInscritas.get(i).getNombre1()+" "+cedulasInscritas.get(i).getNombre2()+" "+cedulasInscritas.get(i).getApellido1()+" "+cedulasInscritas.get(i).getApellido2()+" "+cedulasInscritas.get(i).getNumerocedula();
			ciudinscritos[p]=auxc;
			p++;
			}
			
		}
			
			return ciudinscritos;
	}
	
	
	
	public static void main (String[]args) {
		Registraduria r = new Registraduria();
		
			
		
	}
	

	

}
