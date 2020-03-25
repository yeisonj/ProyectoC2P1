/* Interface que representa un comportamiento de transformar un Date a un entero
 */

/**
 * <h1>Representa un comportamiento</h1>
* Se encarga de representar el comportamiento de transformar un Date a un entero
* @version 1.0
* @author Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo, Diego Torres | Universidad El Bosque
 */

package co.edu.unbosque.model;

import java.util.Date;

public interface TransformarDate {
	
	/***
	 * Este m�todo convierte un dato Date en un entero
	 * <b>post</b> Se ha convertido el dato de tipo Date en un entero <br>
	 * @return un numero entero (dec)
	 */
	int transformarDate();

}
