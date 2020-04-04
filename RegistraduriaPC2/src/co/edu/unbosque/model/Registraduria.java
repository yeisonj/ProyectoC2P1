/* Clase que modela una Registradur�a donde se har� el manejo de datos de inscripci�n de c�dulas para votaci�n
 */

/**
 * <h1>Modela la Registradur�a en su apartado de inscripcion de c�dulas para votaci�n</h1>
* Se encarga de modelar todos los atributos y metodos de la registradur�a en c�dulas para votaci�n
* @version 1.0
* @author Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Registraduria  {

	
	public Registraduria() {
		
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

	
	
	
	
	public String mostrarInformacionPuesto(String puesto, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String aux=cedulasInscritas.get(i).getPuestovotacionasignado();
		
			if(aux==puesto) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
		
	public String mostrarInformacionMunicipio(String municipio, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[1]==municipio) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
	
	public String mostrarInformacionDepartamento(String departamento, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
		
			if(aux[0]==departamento) {
				p++;
			}
		}
		
		return Integer.toString(p);
	}
	
	public int calcularEstadisticasDeEdad(String localizacion, String vLocalizacion, String rango, ArrayList <Ciudadano> cedulasInscritas) {
		int cant =0;
		switch(rango) {
		
		case "1":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}
			}
			break;
			
		case "2":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) &  cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion)& cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}
			}
			break;
			
		case "3":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) &  cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}
			}
			break;
			
		case "4":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}
			}
			break;
			
		case "5":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66) {
					cant++;
				}
			}
			break;
			
		case "6":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(",");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamento") & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipio") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puesto de votacion") & aux[2].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 67) {
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
	
	public String[] mostrarCiudadanosInscritosPuesto(String puesto, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionPuesto(puesto, cedulasInscritas))];
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
	
	public String[] mostrarCiudadanosInscritosMunicipio(String municipio, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionMunicipio(municipio, cedulasInscritas))];
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
		
	public String[] mostrarCiudadanosInscritosDepartamento(String departamento, ArrayList <Ciudadano> cedulasInscritas) {
		int p=0;
		String[] ciudinscritos= new String[Integer.parseInt(mostrarInformacionDepartamento(departamento, cedulasInscritas))];
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
	
	public String[] mostrardepartamentos(ArrayList <String> puestosDeVotacion)
	{
		String[] prueba = new String[35];
		int contador = 0;
		String validar = "1";
		
		for(int i= 0; i<puestosDeVotacion.size(); i++)
		{
			String[] divisiones =puestosDeVotacion.get(i).split(";");
			String departamentos = divisiones[0];
			
				if(!validar.contentEquals(departamentos))
					{
						if(contador<35)
						{
							prueba[contador] = departamentos;
							contador ++;
						}
					}
			validar = departamentos;
			
		}
		return prueba;
	}
	
	public double[] estadisticasGeneroPais(ArrayList <Ciudadano> cedulasInscritas) {
		
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
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
	}
		
	public double [] estadisticasGeneroDepartamento(String departamento, ArrayList <Ciudadano> cedulasInscritas) {
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
		
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
	}
		
	public double [] estadisticasGeneroMunicipio(String municipio, ArrayList <Ciudadano> cedulasInscritas) {
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
		
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
	}
	
	public double [] estadisticasGeneroPuesto(String puesto, ArrayList <Ciudadano> cedulasInscritas) {
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
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
		
	}
	
	
	
	
	

	
	

}
