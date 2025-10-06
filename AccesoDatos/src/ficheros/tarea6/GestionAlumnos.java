package ficheros.tarea6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class GestionAlumnos {
	public static void main(String[] args) {
		/*1.Crear un menu Generar un fichero vacio para añadir alumnos y es eun fichero principal
		 * 2.Coger ya un fichero con alumnos 
		 * 3.Cargar los alumnos del fichero existente al fichero creado vacio ()
		 * 4.mostrar los alumnos  del fichero en uso ya cargado con los alumnos del ficheor existenete */
		
		int opcion=0;
		do {
		Scanner entrada =new Scanner(System.in);
		
		System.out.println("1.Generamos el archivo vacio que usaremos "
				+ "2.Leer objeto de tipo alumno en un fichero existente con alumnos "
				+ "3.Pasar los datos del fichero existente al fichero vacio"
				+ "4.Leer los datos del alumno"
				+ "5.Salir del programa");
		 opcion=entrada.nextInt();
		
		switch(opcion) {
		case 1:
			try {
				FileOutputStream fo=new FileOutputStream("vacio.dat",true);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case 2:
			System.out.println("Dime el fichero existente con alumnos ");
			String ruta=entrada.next();
			break;
		}
		}while(opcion!=5);
		
	
	}
}
