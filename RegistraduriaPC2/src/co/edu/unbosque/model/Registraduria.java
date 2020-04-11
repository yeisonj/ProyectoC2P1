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
/**
 * Esta clase registraduria alberga métodos relacionados con la administración de ciudadanos y puestos de votación. 
 * @author Sebastian Moncaleano, Moisés Salcedo, Diego Torres
 *
 */
public class Registraduria  {

	/**
	 * Constructor de clase Registraduria
	 */
	public Registraduria() {
		
	}
	
	/**
	 * Este método muestra la cantidad de personas inscritas en un puesto específico
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un monicipio <br>
	 * @param puesto es el nombre del puesto para el que se quiere averiguar la cantidad de personas inscritas.
	 * @param cedulasInscritas es un arraylist donde se encuentran todos los ciudadanos inscritos.
	 * @return este método retorna un string con el número de peronas inscritas en un puesto.
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
	
	/**
	 * Este método muestra la cantidad de personas inscritas en un municipio específico.
	 * 	<b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un monicipio <br>
	 * @param municipio es el nombre del muncipio por el que se quiere averiguar la cantidad de personas inscritas.
	 * @param cedulasInscritas es un arraylist donde se encuentran todos los ciudadanos inscritos.
	 * @return este método retorna un string con el número de peronas inscritas en un municipio.
	 */
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
	
	/**
	 * Este método muestra la cantidad de personas inscritas en un departamento en específico.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un departamento <br>
	 * @param departamento es el nombre del departamento al que se le va a encontrar la cantidad de personas inscritas.
	 * @param cedulasInscritas es un arraylist donde se encuentran todos los ciudadanos inscritos.
	 * @return este método retorna un string con el número de peronas inscritas en un departamento.
	 */
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
	
	/**
	 * Este metodo retorna las estadísticas de edad de un país, departamento, municipio y edad.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un rango <br>
	 * @param localizacion
	 * @param vLocalizacion
	 * @param rango es el rango de edad a calcular.
	 * @param cedulasInscritas es el ArrayList con todos los ciudadanos inscritos.
	 * @return Este método retorna la cantidad de personas inscritas que se encuentran en un rango de edad.
	 */
	public int calcularEstadisticasDeEdad(String localizacion, String vLocalizacion, String rango, ArrayList <Ciudadano> cedulasInscritas) {
		int cant =0;
		switch(rango) {
		
		case "1":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 18 & cedulasInscritas.get(i).transformarDate() <=25) {
					cant++;
				}
			}
			break;
			
		case "2":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) &  cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion)& cedulasInscritas.get(i).transformarDate() >= 26 & cedulasInscritas.get(i).transformarDate() <=29) {
					cant++;
				}
			}
			break;
			
		case "3":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) &  cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 30 & cedulasInscritas.get(i).transformarDate() <=37) {
					cant++;
				}
			}
			break;
			
		case "4":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 38 & cedulasInscritas.get(i).transformarDate() <=49) {
					cant++;
				}
			}
			break;
			
		case "5":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") & aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66	) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 50 & cedulasInscritas.get(i).transformarDate() <=66) {
					cant++;
				}
			}
			break;
			
		case "6":
			for(int i = 0; i < cedulasInscritas.size(); i++) {
				String [] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
				if(localizacion.equalsIgnoreCase("PAIS") & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Departamentos") &  aux[0].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Municipios") & aux[1].equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}else if(localizacion.equalsIgnoreCase("Puestos de votación") & aux[2].concat(";"+aux[3]).equalsIgnoreCase(vLocalizacion) & cedulasInscritas.get(i).transformarDate() >= 67) {
					cant++;
				}
			}
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Este rango de edad no se encentra entre las estadï¿½sticas");
			break;
		
		
		}
		
		return cant;

	}
	
	/**
	 * Este método calcula la cantidad de ciudadanos inscritos en un puesto.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un puesto <br>
	 * @param puesto es el puesto de vtació al que se le van a calcular la cantidad de ciudadanos inscritos.
	 * @param cedulasInscritas es el Arraylist con todos los ciudadanos inscritos.
	 * @return Este metodo devuelve un string con la cantidad de personas inscritas en un puesto.
	 */
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
	
	/**
	 * Este método calcula la cantidad de personas inscritas en un departamento.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un municipio <br>
	 * @param municipio es el nomdre del municipio al que se le desea hallar el número de personas inscritas
	 * @param cedulasInscritas es el Arraylist con todos los ciudadanos inscritos.
	 * @return se retorna un String con la cantidad de personas inscritas
	 */
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
	
	/**
	 * Este método calcula la cantidad de personas inscritas en un departamento.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado la cantidad de personas inscritas en un departamento <br>
	 * @param departamento es el nomdre del departamento al que se le desea hallar el número de personas inscritas
	 * @param cedulasInscritas es el Arraylist con todos los ciudadanos inscritos.
	 * @return se retorna un String con la cantidad de personas inscritas.
	 */
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
	
	/**
	 * Este método se encarga de retonar los departamentos dentro del país
	 * <b>pre</b> La lista de puestos de votación est� cargada (no es null). <br>
	 * <b>post</b> Se han incluido los departamentos en el array de Strings y se ha retornado el array.<br>
	 * @param puestosDeVotacion es el ArrayList de todos los puestos de votación.
	 * @return Retorna todos los departamentos en un Array de String
	 */
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
	
	/**
	 * Este método se encarga de retonar los Municipios dentro del país
	 * <b>pre</b> La lista de puestos de votación est� cargada (no es null). <br>
	 * <b>post</b> Se han incluido los municipios en el ArrayList de Strings y se ha retornado el arrayList.<br>
	 * @param puestosDeVotacion es el ArrayList de todos los puestos de votación.
	 * @return Retorna todos los municipios en un ArrayList de Strings.
	 */
	
	public ArrayList<String> mostrarmunicipios(ArrayList <String> puestosDeVotacion)
	{
		ArrayList<String> prueba = new ArrayList<String>();
		String validar = "1";
		
		for(int i= 0; i<puestosDeVotacion.size(); i++)
		{
			String[] divisiones =puestosDeVotacion.get(i).split(";");
			String municipios = divisiones[1];
			
				if(!validar.contentEquals(municipios))
					{
							prueba.add(municipios);	
					}
			validar = municipios;
			
		}
		return prueba;
	}
	
	/**
	 * Este método se encarga de encontrar las estadísticas de genero para el país.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado las estadísticas de género de un país <br>
	 * @param cedulasInscritas es el Arraylist con los ciudadanos inscritos.
	 * @return Este metodo devuelve un arreglo de double con dos posiciones cada uno con el
	 * porcentaje de hombres y mujeres inscritos en el país.
	 */
	
	public double[] estadisticasGeneroPais(ArrayList <Ciudadano> cedulasInscritas) {
		
		int m=0, f=0;
		double porcentajem, porcentajef;
		for (int i = 0; i < cedulasInscritas.size(); i++) {
			String aux=cedulasInscritas.get(i).getGenero();
			System.out.println(aux);
			if(aux.equalsIgnoreCase("Femenino")){
			f++;
			}else {
			
			m++;	
			}
			
		}
		
		

		porcentajef=(f*100)/(f+m);
		porcentajem=100-porcentajef;
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
	}
	
	/**
	 * Este método se encarga de encontrar las estadísticas de genero para un departamento.
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado las estadísticas de género de un departamento <br>
	 * @param departamento es el nombre del departamento del que se quiere conocer las estadísticas de género.
	 * @param cedulasInscritas es el Arraylist con los ciudadanos inscritos
	 * @return Este metodo devuelve un arreglo de double con dos posiciones cada uno con el
	 * porcentaje de hombres y mujeres inscritos en un departamento
	 */
	
	public double [] estadisticasGeneroDepartamento(String departamento, ArrayList <Ciudadano> cedulasInscritas) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
			if(aux[0].equalsIgnoreCase(departamento)) 
			{
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f++;
				}else {
			
					m++;	
				}
			
			}
		
		}
		try {
		porcentajef=(f*100)/(f+m);
		porcentajem=100-porcentajef;
		
		
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
	return porcentajes;
		}
	catch(ArithmeticException e)
	{
		return null;
	}
	
	}
	/**
	 * Este método se encarga de encontrar las estadísticas de genero para un municipio
	 * <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado las estadísticas de género de un municipio <br>
	 * @param municipio es el nombre del municipio del que se quiere conocer las estadísticas de género.
	 * @param cedulasInscritas es el Arraylist con los ciudadanos inscritos
	 * @return Este metodo devuelve un arreglo de double con dos posiciones cada uno con el
	 * porcentaje de hombres y mujeres inscritos en un municipio
	 */
	
	public double [] estadisticasGeneroMunicipio(String municipio, ArrayList <Ciudadano> cedulasInscritas) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
			if(aux[1].equalsIgnoreCase(municipio)) {
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f+=1;
				}else {
			
					m+=1;	
				}
			
			}
		
		}
		try {
		porcentajef=(f*100)/(f+m);
		porcentajem=100-porcentajef;
		
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
		return porcentajes;
		}
		catch(ArithmeticException e)
		{
			return null;
		}
	}
	
	/**
	 * Este método se encarga de encontrar las estadísticas de genero para un puesto
	 *  <b>pre</b> La lista de ciudadanos est� inicializada (no es null). <br>
	 * <b>post</b> Se ha calculado y retornado las estadísticas de género de un puesto <br>
	 * @param puesto es el nombre del puesto de votación del que se quiere conocer las estadísticas de género
	 * @param cedulasInscritas es el arrayList con los ciudadanos inscritos
	 * @return Este metodo devuelve un arreglo de double con dos posiciones cada uno con el
	 * porcentaje de hombres y mujeres inscritos en un puesto de votación
	 */
	
	public double [] estadisticasGeneroPuesto(String puesto, ArrayList <Ciudadano> cedulasInscritas) {
		int m=0, f=0;
		double porcentajem, porcentajef;
		
		for (int i = 0; i < cedulasInscritas.size(); i++) {
		String[] aux=cedulasInscritas.get(i).getPuestovotacionasignado().split(";");
		String mun = aux[2].concat(";"+aux[3]);
			if(mun.equalsIgnoreCase(puesto)) {
				String auxg=cedulasInscritas.get(i).getGenero();
			
				if(auxg.equalsIgnoreCase("Femenino")) {
					f+=1;
				}else {
			
					m+=1;	
				}
			
			}
		
		}
		try {
		porcentajef=(f*100)/(f+m);
		porcentajem=100-porcentajef;
		double [] porcentajes= new double[2];
		porcentajes[0]=porcentajef;
		porcentajes[1]= porcentajem;
		
		return porcentajes;
		}
		catch(ArithmeticException e)
		{
			return null;
		}
		
	}
	
	
	
	
	

	
	

}
