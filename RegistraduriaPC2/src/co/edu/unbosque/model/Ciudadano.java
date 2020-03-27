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
	
	
	@Override
	public String toString() {
		return "numerocedula= " + numerocedula + ", nombre1= " + nombre1 + ", nombre2= " + nombre2
				+ ", apellido1= " + apellido1 + ", apellido2= " + apellido2 + ", lugardenacimiento= " + lugardenacimiento
				+ ", genero= " + genero + ", lugarexpedicioncedula= " + lugarexpedicioncedula + ", fechanacimiento= "
				+ fechanacimiento + ", fechaexpedicion= " + fechaexpedicion + ", puestovotacionasignado= "
				+ puestovotacionasignado;
	}

	@Override
	public int transformarDate() {
		LocalDate 			fechaNac 	= this.fechanacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate 			ahora 		= LocalDate.now();
		Period 				periodo 	= Period.between(fechaNac, ahora);
		
		return periodo.getYears();
	}
	
	
}
