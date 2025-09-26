package ficheros.tarea3.ej3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroExistenteAppend {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		try {
			FileWriter fw = new FileWriter("Ejercicio3.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			String cadena = "";
			while (!cadena.contains("salir")) {
				System.out.println("Dime la frase y si quieres salir dime 'SALIR' en minuscula o mayuscula");
				cadena = entrada.nextLine();
				if (cadena.contains("SALIR") || cadena.contains("salir")) {
					System.out.println("La frase contiene la palabra stop");
					System.out.println("Salimos del programa");
					break;
				}
				pw.println(cadena);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
