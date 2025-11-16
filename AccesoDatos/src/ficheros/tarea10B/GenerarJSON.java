package ficheros.tarea10B;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ficheros.tarea4.Alumno;

public class GenerarJSON {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ArrayList<Alumno> lista = new ArrayList<>();

	        System.out.println("Introduce los datos de 5 alumnos:");

	        for (int i = 1; i <= 5; i++) {
	            System.out.println("\nAlumno " + i + ":");
	            System.out.print("NIA: ");
	            int nia = sc.nextInt();
	            sc.nextLine(); // limpiar buffer
	            System.out.print("Nombre: ");
	            String nombre = sc.nextLine();
	            System.out.print("Apellidos: ");
	            String apellidos = sc.nextLine();
	            System.out.print("Género (H/M): ");
	            char genero = sc.nextLine().toUpperCase().charAt(0);
	            System.out.println("Dime el año de nacimiento");
	            int anio=sc.nextInt();
	            sc.nextLine();
	            System.out.println("Dime el mes de nacimiento");
	            int mes=sc.nextInt();
	            sc.nextLine();
	            System.out.println("Dime el dia de nacimiento");
	            int dia=sc.nextInt();
	            sc.nextLine();
	            System.out.print("Ciclo: ");
	            String ciclo = sc.nextLine();
	            System.out.print("Curso: ");
	            String curso = sc.nextLine();
	            System.out.print("Grupo: ");
	            String grupo = sc.nextLine();

	            lista.add(new Alumno(nombre,apellidos,ciclo,curso,grupo,genero,LocalDate.of(anio, mes, dia),nia));
	        }

	        Gson gson = new GsonBuilder()
	                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
	                .setPrettyPrinting()
	                .create();


	        try (FileWriter writer = new FileWriter("alumnos.json")) {
	            gson.toJson(lista, writer);
	            System.out.println("Archivo JSON generado correctamente: alumnos.json");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        sc.close();
	    }
}
