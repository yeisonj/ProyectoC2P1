/* Clase que modela una Registradur�a donde se har� el manejo de datos de inscripci�n de c�dulas para votaci�n
 */

/**
 * <h1>Modela la Registradur�a en su apartado de inscripcion de c�dulas para votaci�n</h1>
* Se encarga de modelar todos los atributos y metodos de la registradur�a en c�dulas para votaci�n
* @version 1.0
* @author Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import co.edu.unbosque.model.persistence.*;
import javax.swing.JOptionPane;

public class Registraduria  {
	
	private ArrayList <Ciudadano> cedulasInscritas = new ArrayList();
	private ArrayList <String> puestosDeVotacion = new ArrayList();
	Archivo arc = new Archivo();
	
	public Registraduria() {
		
		arc.cargarListaPuestosDeVotacion(puestosDeVotacion);
		arc.cargarBaseDatos(cedulasInscritas);
	}
	
	
	
	/**
	* Este m�todo agrega un ciudadano a un puesto de votaci�n
	* <b>pre</b> La lista de ciudadanos est� inicializada (no es
	null). <br>
	* <b>post</b> Se ha registrado un nuevo ciudadano con los
	datos dados <br>
	* @param cedula Es la c�dula del nuevo cidadano. cedula != null,
	cedula != " "
	*/
	public void agregarCiudadano(Ciudadano ciudadanoAInscribir) {
		
		cedulasInscritas.add(ciudadanoAInscribir);
		arc.guardarBaseDatos(cedulasInscritas);
		
		
		
		
	}
	

	
	public String mostrarInformacionCiudadano(String numeroCedula) {
		String showCiu="";
		for(int j= 0;j < cedulasInscritas.size(); j++)  {
			String cc = cedulasInscritas.get(j).getNumerocedula();
			if(numeroCedula.equalsIgnoreCase(cc)) {
				showCiu = cedulasInscritas.get(j).toString();
			}
		}
		return showCiu;
	}
	
	public void eliminarCiudadano(String numeroCedula) {
		for(int j= 0;j < cedulasInscritas.size(); j++)  {
			String cc = cedulasInscritas.get(j).getNumerocedula();
			if(numeroCedula.equalsIgnoreCase(cc)) {
				cedulasInscritas.remove(j);	
			}
		}
		arc.guardarBaseDatos(cedulasInscritas);
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
			JOptionPane.showMessageDialog(null, "Este rango de edad no se encentra entre las estad�sticas");
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
	
	public String estadisticasGeneroPais() {
		
		int m=0, f=0;
		double porcentajem, porcentajef;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String aux=cedulasInscritas.get(i).getGenero();
		
			if(aux.equalsIgnoreCase("Femenino")){
			f+=1;
			}else {
			
			m+=1;	
			}
			
		}

		porcentajef=(f/cedulasInscritas.size())*100;
		porcentajem=100-porcentajef;
		
	return "El porcentaje de mujeres inscritas es: "+porcentajef+"% y el total de hombres inscritos es: "+porcentajem+"%";
	}
	
	
	public String estadisticasGeneroDepartamento(String departamento) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
			if(aux[0]==departamento) {
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f+=1;
				}else {
			
					m+=1;	
				}
			
			}
		
		}
		
		porcentajef=(f/(f+m))*100;
		porcentajem=100-porcentajef;
		
		return "El porcentaje de mujeres inscritas es: "+porcentajef+"% y el total de hombres inscritos es: "+porcentajem+"%";
	}
	
	
	
	
	
	public String estadisticasGeneroMunicipio(String municipio) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
			if(aux[1]==municipio) {
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f+=1;
				}else {
			
					m+=1;	
				}
			
			}
		
		}
		
		porcentajef=(f/(f+m))*100;
		porcentajem=100-porcentajef;
		
		return "El porcentaje de mujeres inscritas es: "+porcentajef+"% y el total de hombres inscritos es: "+porcentajem+"%";
	}
	
	public String estadisticasGeneroPuesto(String puesto) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
			if(aux[2]==puesto) {
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f+=1;
				}else {
			
					m+=1;	
				}
			
			}
		
		}
		
		porcentajef=(f/(f+m))*100;
		porcentajem=100-porcentajef;
		
		return "El porcentaje de mujeres inscritas es: "+porcentajef+"% y el total de hombres inscritos es: "+porcentajem+"%";
	}
	
	
	
	
	public static void main (String[]args) {
		Registraduria r = new Registraduria();
		Date d1 = new Date("11/12/1994");
		Date d2 = new Date("12/11/2003");
		Date d3 = new Date("11/12/1997");
		
		Ciudadano ciu = new Ciudadano("12345", "Moncaleano", "Sebastian", "Cali, Valle", "Masculino", "Cali, valle", null, null, d1, d3, "Cali");
		Ciudadano ciu1 = new Ciudadano("123456", "Moncaleanoao", "Sebastianao", "Cali, Valle", "Masculino", "Cali, valle", null, null, d2, d3, "Cali");
		Ciudadano ciu2 = new Ciudadano("1234567", "Moncaleanoao", "JUAN", "Cali, Valle", "Masculino", "Cali, valle", null, null, d3, d3, "Cali");
		Ciudadano ciu3 = new Ciudadano("12345678", "Moncaleanoao", "JUAN", "Cali, Valle", "Masculino", "Cali, valle", null, null, d3, d3, "BOGOTA");
		r.agregarCiudadano(ciu);
		r.agregarCiudadano(ciu1);
		r.agregarCiudadano(ciu2);
		r.agregarCiudadano(ciu3);
		System .out.println(r.calcularEstadisticasDeEdad("1"));
		System .out.println(r.mostrarInformacionCiudadano("123456"));
	

	}
	

	

}
