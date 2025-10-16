package ficheros.tarea6;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import ficheros.tarea5.Alumno5;

public class GestionAlumnos {
	public static void main(String[] args) {
		/*1.Crear un menu Generar un fichero vacio para añadir alumnos y es eun fichero principal
		 * 2.Coger ya un fichero con alumnos 
		 * 3.Cargar los alumnos del fichero existente al fichero creado vacio ()
		 * 4.mostrar los alumnos  del fichero en uso ya cargado con los alumnos del fichero existente */
		
		int opcion=0;
		do {
		Scanner entrada =new Scanner(System.in);
		
		System.out.println("1.Generamos el archivo vacio que usaremos "
				+ "2.Leer objeto de tipo alumno en un fichero existente con alumnos "
				+ "3.Insertar el alumno en el fichero en uso"
				+ "4.Leer los datos del alumno del fichero en uso"
				+ "5.Salir del programa");
		 opcion=entrada.nextInt();

		System.out.println("Dime el fichero a utilizar");
		String fichero_uso=entrada.nextLine();
		switch(opcion) {
		case 1:
			try(FileOutputStream fo=new FileOutputStream(fichero_uso,true)) {
				System.out.println("El fichero en uso es "+ fichero_uso);
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			break;
			
		case 2:
			System.out.println("Dime el fichero existente");
			fichero_uso =entrada.next();
			File fi=new File(fichero_uso);
			if(fi.exists()) {
				System.out.println("El fichero existe");
				
			}else {
				System.out.println("El fichero no existe, vuelve a escribir un fichero inexistente");
				fichero_uso=null;
				}
		
			
			
			break;
		
		
		
		case 3:
		    if (fichero_uso == null) {
		        System.out.println("Primero debes crear o seleccionar un fichero.");
		        break;
		    }

		    System.out.print("NIA: ");
		    int nia = entrada.nextInt();
		    entrada.nextLine();
		    System.out.print("Nombre: ");
		    String nombreAlumno = entrada.nextLine();
		    System.out.print("Apellidos: ");
		    String apellidos = entrada.nextLine();
		    System.out.print("Género (M/F): ");
		    char genero = entrada.next().charAt(0);
		    System.out.println("Dime el año de nacimiento");
		    int anio=entrada.nextInt();
		    System.out.println("Dime el mes de nacimiento");
		    int mes=entrada.nextInt();
		    System.out.println("Dime el dia de nacimiento");
		    int dia =entrada.nextInt();
		    System.out.print("Ciclo: ");
		    String ciclo = entrada.next();
		    System.out.print("Curso: ");
		    String curso = entrada.next();
		    System.out.print("Grupo: ");
		    String grupo = entrada.next();

		    Alumno5 alumno = new Alumno5(nombreAlumno, apellidos, ciclo, curso, grupo, nia, grupo,LocalDate.of(anio, mes, dia));

		    try (FileOutputStream fo = new FileOutputStream(fichero_uso, true);
		         ObjectOutputStream o = new ObjectOutputStream(fo)) {
		        o.writeObject(alumno);
		        System.out.println("Alumno añadido correctamente.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    break;

			
		case 4:
			
			break;
			
			
		case 5: 
			break;

		}
		
		}while(opcion!=5);
		
	
	}
}
