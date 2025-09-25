package ficheros.tarea2.ej2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Crea un programa en Java que guarde en un fichero de texto lo que el usuario
escriba por la línea de comandos (línea a línea). Para finalizar, el usuario deberá
escribir una línea con la palabra “exit” (no debe aparecer en el fichero de texto).*/
public class EscrituraFichero {
	public static void main(String[] args) {
		try {
			Scanner entrada = new Scanner(System.in);
			FileWriter fw = new FileWriter("Ejercicio2.txt");
			PrintWriter pr = new PrintWriter(fw);
			String palabra="x";
			while (!palabra.contains("exit")) {
				System.out.println("Dime la frase ,escribe exit en minuscula para salir del programa ");
				 palabra = entrada.nextLine();
				if (palabra.contains("exit")) {
					System.out.println("Se termina el programa");
					break;
				}
				pr.println(palabra);
				
			}
			pr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
