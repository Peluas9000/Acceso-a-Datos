package ficheros.tarea5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GestionLeerAlumnos5 {
	public static void main(String[] args) {
		try (FileInputStream fi = new FileInputStream("Ejercicio5.dat");
				ObjectInputStream oi = new ObjectInputStream(fi)) {

			while (true) {
				try {
					Alumno5 alumno = (Alumno5) oi.readObject();
					System.out.println(
							"Alumno del ciclo de " + alumno.getCiclo() + " que se llama " + alumno.getNombre());
				} catch (EOFException e) {
					// Se acabó el fichero
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
