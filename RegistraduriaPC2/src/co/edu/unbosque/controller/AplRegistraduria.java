package co.edu.unbosque.controller;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.View;

public class AplRegistraduria {

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
