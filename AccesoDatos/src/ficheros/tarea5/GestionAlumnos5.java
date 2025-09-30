package ficheros.tarea5;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import ficheros.tarea1.Alumno;

public class GestionAlumnos5 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		DataOutputStream dp = null;

		try {
			FileOutputStream fo=new FileOutputStream("Ejercicio5.dat"); 
			dp = new DataOutputStream(fo);
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			
			for (int i = 0; i <1; i++) {
				System.out.println("Dime los siguientes datos para el alumno numero " + i);
				System.out.println("Dime tu nombre");
				String nombre = entrada.next();
				System.out.println("Apellidos");
				String apellidos = entrada.next();
				System.out.println("Dime el ciclo que cursas");
				String ciclo = entrada.next();
				System.out.println("Dime en que curso del ciclo estas ");
				String curso = entrada.next();
				System.out.println("Dime el grupo del curso estas");
				String grupo = entrada.next();
				System.out.println("Dime tu NIA");
				int nia = entrada.nextInt();
				System.out.println("Dime tu genero entre H Y M");
				String genero = entrada.next();
				System.out.println("Dime el año de tu fecha de nacimiento");
				int anio = entrada.nextInt();
				System.out.println("Dime el mes de tu fecha de nacimiento");
				int mes = entrada.nextInt();
				System.out.println("Dime el dia de tu fecha de nacimiento");
				int dia = entrada.nextInt();
				Alumno5 alumno = new Alumno5(nombre, apellidos, ciclo, curso, grupo, nia, genero,
						LocalDate.of(anio, mes, dia));
				
					oo.writeObject(alumno);
					
			

		} oo.close();
			
			}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		} finally{
			try {
			if(dp!=null) {
				dp.close();
			}
		}catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
		}
		}
		
	}

}
