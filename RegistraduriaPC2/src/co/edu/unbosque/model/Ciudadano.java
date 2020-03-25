/* Clase que modela un ciudadano que va se va a registrar en un puesto de votación
 */

/**
 * <h1>Modela un ciudadano</h1>
* Se encarga de modelar todos los atributos de un ciudadano que se registra en un puesto de votación
* @version 1.0
* @author Jeisson Jossa, Sebastián Moncaleano, Moisés Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Ciudadano implements TransformarDate, Serializable {
	
	private String numeroCedula;
	private String apellidos;
	private String nombres;
	private String lugarDeNacimiento;
	private String sexo;
	private String lugarDeExpedicionC;
	private Date fechaNacimiento;
	private Date fechaExpedicionC;
	private String puestoVotacion;
	//prueba github
	//Constructor de la clase Ciudadano
	
	public Ciudadano(String numeroCedula, String apellidos, String nombres, String lugarDeNacimiento, String sexo,
			String lugarDeExpedicionC, Date fechaNacimiento, Date fechaExpedicionC, String puestoVotacion) {
		super();
		this.numeroCedula = numeroCedula;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.lugarDeNacimiento = lugarDeNacimiento;
		this.sexo = sexo;
		this.lugarDeExpedicionC = lugarDeExpedicionC;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaExpedicionC = fechaExpedicionC;
		this.puestoVotacion = puestoVotacion;

	}
	
	//Getters y setter de los atributos de la clase Ciudadano
	
	public String getNumeroCedula() {
		return numeroCedula;
	}
	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getLugarDeNacimiento() {
		return lugarDeNacimiento;
	}
	public void setLugarDeNacimiento(String lugarDeNacimiento) {
		this.lugarDeNacimiento = lugarDeNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getLugarDeExpedicionC() {
		return lugarDeExpedicionC;
	}
	public void setLugarDeExpedicionC(String lugarDeExpedicionC) {
		this.lugarDeExpedicionC = lugarDeExpedicionC;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaExpedicionC() {
		return fechaExpedicionC;
	}
	public void setFechaExpedicionC(Date fechaExpedicionC) {
		this.fechaExpedicionC = fechaExpedicionC;
	}
	public String getPuestoVotacion() {
		return puestoVotacion;
	}
	public void setPuestoVotacion(String puestoVotacion) {
		this.puestoVotacion = puestoVotacion;
	}

	@Override
	public String toString() {
		return numeroCedula + ";" + apellidos + ";" + nombres
				+ ";" + lugarDeNacimiento + ";" + sexo + ";"
				+ lugarDeExpedicionC + ";" + fechaNacimiento + ";" + fechaExpedicionC
				+ ";" + puestoVotacion;
	}

	@Override
	public int transformarDate() {
		LocalDate 			fechaNac 	= this.fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		LocalDate 			ahora 		= LocalDate.now();
		Period 				periodo 	= Period.between(fechaNac, ahora);
		return periodo.getYears();
		
	}


	

	
	

}
