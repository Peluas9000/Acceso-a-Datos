package ficheros.tarea10B;

import java.time.LocalDate;

import ficheros.tarea4.Alumno;

public class GenerarJSON {
	public static void main(String[] args) {
		int cont = 0;
		do {
			System.out.println("Dime el nombre");
			System.out.println("Dime el apellido ");
			System.out.println("Dime el ciclo");
			System.out.println("Dime el curso");
			System.out.println("Dime el grupo");
			System.out.println("Dime el genero");
			System.out.println("Dime el año de nacimiento");
			System.out.println("Dime el mes de nacimiento");
			System.out.println("Dime el dia de nacimiento");
			System.out.println("Dime tu NIA");

			Alumno a = new Alumno("Ayoub", "BenJaddi", "DAM", "1", "A", 'H', LocalDate.of(2005, 11, 19), 73243);
			cont++;
			//CREAMOS EL GSON Y AÑADIMOS AL FORMATO DE ARCHIVO CON EXTENSION JSON
			
			
			
		} while (cont < 1);
	}

}
