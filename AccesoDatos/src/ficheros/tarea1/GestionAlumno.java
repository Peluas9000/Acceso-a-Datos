package ficheros.tarea1;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class GestionAlumno {
	public static void main(String[] args) {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Alumno a1 = new Alumno("Ayoub", "Gutierrez", "dam", "segundo", "D", 1256, "H", LocalDate.of(2005, 11, 19));
		Alumno a2 = new Alumno("Pilar", "Santos", "dam", "segundo", "A", 5322, "M", LocalDate.of(2000, 12, 12));
		Alumno a3 = new Alumno("Guillermo", "Garcia", "ASIR", "PRIMERO", "B", 321, "H", LocalDate.of(1995, 1, 30));
		Alumno a4 = new Alumno("Guillermo", "Chueca", "ADE", "segundo", "A", 7854, "H", LocalDate.of(2010, 3, 20));
		Alumno a5 = new Alumno("Miguel", "Peña", "DAW", "PRIMERO", "C", 243231, "H", LocalDate.of(2004, 04, 04));

		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a5);

		for (Alumno alumnos : lista) {
			System.out.println(lista);
		}

		// Ordenarlos por nia
		lista.sort(Comparator.comparingInt(Alumno::getNia).reversed());
		for(Alumno a:lista) {
			System.out.println(a);
		}

		// opcional 2
		ArrayList<Alumno> lista2 = new ArrayList<Alumno>();
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Dime el nombre ");
			String nombre = entrada.next();
			System.out.println("Dime el apellido");
			String apellido = entrada.next();

			System.out.println("Dime el curso estas cursando");
			String curso = entrada.next();

			System.out.println("Que año del curso estas");
			String curso_anio = entrada.next();

			System.out.println("De que grupo eres");
			String grupo = entrada.next();

			System.out.println("Dime tu NIA de alumno ");
			int nia = entrada.nextInt();
			System.out.println("Que genero eres");
			String genero = entrada.next();

			System.out.println("Dime el año de nacimiento");
			int anio = entrada.nextInt();
			System.out.println("Dime el mes de nacimiento");
			int mes = entrada.nextInt();

			System.out.println("Dime el dia de nacimiento");
			int dia = entrada.nextInt();

			Alumno alumno = new Alumno(nombre, apellido, curso, curso_anio, grupo, nia, genero,
					LocalDate.of(anio, mes, dia));

			lista2.add(alumno);
		}
	}

}
