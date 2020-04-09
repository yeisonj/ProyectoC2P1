/* Interface que representa un comportamiento de transformar un Date a un entero
 */

/**
 * <h1>Representa un comportamiento</h1>
* Se encarga de representar el comportamiento de transformar un Date a un entero
* @version 1.0
* @author Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo, Diego Torres | Universidad El Bosque
 */

/**
 * Esta interfaz contiene los métodos encargados de calcular tiempo en años desde una fecha específica.
 * @author Sebastian Moncaleano
 */
package co.edu.unbosque.model;

import java.util.Date;

public interface TransformarDate {
	/***
	 * Este m�todo convierte un dato Date en un entero en años
	 * <b>post</b> Se ha convertido el dato de tipo Date en un entero <br>
	 * @return un numero entero de la cantidad de años
	 */
	int transformarDate();

}
