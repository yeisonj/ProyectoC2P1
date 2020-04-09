package co.edu.unbosque.controller;

/* clase que contiene el main del programa
 * 
 */

/** <h1>Clase que contiene el main del programa</h1>
 *  @version 1.0
* @author Diego Torres, Jeisson Jossa, Sebasti�n Moncaleano, Mois�s Salcedo| Universidad El Bosque
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AplRegistraduria {

	/**método main, inicializa el programa
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	
		Controller controller = new Controller();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

	}

}
