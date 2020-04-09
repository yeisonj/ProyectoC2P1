/* Clase que modela un ciudadano que va se va a registrar en un puesto de votaci�n
 */

/**
 * <h1>Modela un ciudadano</h1>
* Se encarga de modelar todos los atributos de un ciudadano que se registra en un puesto de votaci�n
* @version 1.0
* @author Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * la clase ciudadano contiene la información de los votantes, esta clase implementa 
 * la interfaz transformar date la cual arroja la edad con respecto a la fecha de 
 * nacimiento del votante. Los objetos de esta clase son guardados en forma serializada para
 * la protección de los datos de los votantes.
 * @author Sebastian Moncaleano, Moisés Salcedo, Diego Torres, Jeison Jossa
 */

public class Ciudadano implements Serializable, TransformarDate {
	
	private String numerocedula;
	private String nombre1;
	private String nombre2; 
	private String apellido1;
	private String apellido2;
	private String lugardenacimiento;
	private String genero;
	private String lugarexpedicioncedula;
	private Date fechanacimiento;
	private Date fechaexpedicion;
	private String puestovotacionasignado;
	
	/**
	 * Este es el constructor de la clase ciudadano
	 * @param numerocedula es el String del número de identificación del ciudadano.
	 * @param nombre1 es el String del Primer nombre del ciudadano
	 * @param nombre2 es el String del Segundo nombre del ciudadano
	 * @param apellido1 es el String Primer Apellido del ciudadano
	 * @param apellido2 es el String del Segundo Apellido del ciudadano
	 * @param lugardenacimiento es el String la ciudad o municipio donde nació el ciudadano
	 * @param genero es el string que indica el sexo del ciudadano
	 * @param lugarexpedicioncedula es el String con la ciudad o municipio donde fue expedido el documento del ciudadano
	 * @param fechanacimiento Es el date con la fecha de nacimiento del ciudadano
	 * @param fechaexpedicion Es el date con la fecha de expedicion del documento del ciudadano
	 * @param puestovotacionasignado Es el String con el puesto de votación del ciudadano, este incluye departamento, municipio,
	 * nombre y direccion del puesto.
	 */
	
	public Ciudadano(String numerocedula, String nombre1, String nombre2, String apellido1, String apellido2,
			String lugardenacimiento, String genero, String lugarexpedicioncedula, Date fechanacimiento,
			Date fechaexpedicion, String puestovotacionasignado) {
		super();
		this.numerocedula = numerocedula;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.lugardenacimiento = lugardenacimiento;
		this.genero = genero;
		this.lugarexpedicioncedula = lugarexpedicioncedula;
		this.fechanacimiento = fechanacimiento;
		this.fechaexpedicion = fechaexpedicion;
		this.puestovotacionasignado = puestovotacionasignado;
	}

	public String getNumerocedula() {
		return numerocedula;
	}

	public void setNumerocedula(String numerocedula) {
		this.numerocedula = numerocedula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getLugardenacimiento() {
		return lugardenacimiento;
	}

	public void setLugardenacimiento(String lugardenacimiento) {
		this.lugardenacimiento = lugardenacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLugarexpedicioncedula() {
		return lugarexpedicioncedula;
	}

	public void setLugarexpedicioncedula(String lugarexpedicioncedula) {
		this.lugarexpedicioncedula = lugarexpedicioncedula;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Date getFechaexpedicion() {
		return fechaexpedicion;
	}

	public void setFechaexpedicion(Date fechaexpedicion) {
		this.fechaexpedicion = fechaexpedicion;
	}

	public String getPuestovotacionasignado() {
		return puestovotacionasignado;
	}

	public void setPuestovotacionasignado(String puestovotacionasignado) {
		this.puestovotacionasignado = puestovotacionasignado;
	}
	
	/**
	 * El método toString  devuelva la información de un objeto de la clase ciudadano
	 */
	
	@Override
	public String toString() {
		return "numerocedula= " + numerocedula + ", nombre1= " + nombre1 + ", nombre2= " + nombre2
				+ ", apellido1= " + apellido1 + ", apellido2= " + apellido2 + ", lugardenacimiento= " + lugardenacimiento
				+ ", genero= " + genero + ", lugarexpedicioncedula= " + lugarexpedicioncedula + ", fechanacimiento= "
				+ fechanacimiento + ", fechaexpedicion= " + fechaexpedicion + ", puestovotacionasignado= "
				+ puestovotacionasignado;
	}

	/**
	 * El método transformarDate se encarga de tomar la fecha de nacimiento del ciudadano
	 * y calcular la edad del mismo
	 * <b>pre</b> El ciudadano debe tener una fecha de nacimiento en el formato dd/MM/AAAA <br>
	 * <b>post</b> Se ha calculado y retornado la edad del ciudadano <br>
	 * @return retorna la edad del ciudadano en un entero.
	 */
	
	@Override
	public int transformarDate() {
		LocalDate 			fechaNac 	= this.fechanacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate 			ahora 		= LocalDate.now();
		Period 				periodo 	= Period.between(fechaNac, ahora);
		
		return periodo.getYears();
	}
	
	
}
