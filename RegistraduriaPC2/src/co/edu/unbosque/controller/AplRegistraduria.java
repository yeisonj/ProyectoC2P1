package co.edu.unbosque.controller;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import co.edu.unbosque.model.Registraduria;
import co.edu.unbosque.view.View;

public class AplRegistraduria {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		
		Registraduria registraduria=new Registraduria();
		View v = new View();
		v.setSize(800,640);
		v.setTitle("INSCRIPCIÓN DE CÉDULAS");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(null);
		v.setLocationRelativeTo(null);
		v.setResizable(false);
		v.setVisible(true);
		Controller controller = new Controller(v,registraduria);

//branches
	}

}
