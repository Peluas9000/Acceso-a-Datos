package ficheros.tarea2.ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GestionFicheroB {
	public static void main(String[] args) {

		try {

			Scanner entrada = new Scanner(System.in);

			System.out.println("Dime el nombre del ficheor sin la extension txt ");
			String nombre = entrada.next();

			System.out.println("Dime si la ruta es absoluta o relativa");
			String tipo = entrada.nextLine();

			if (tipo.equalsIgnoreCase("absoluta")) {
				System.out.println("Dime la ruta absoluta quitando el nombre del fichero");
				String ruta = entrada.next();
				FileReader fr = new FileReader(ruta + nombre + ".txt");
				BufferedReader br = new BufferedReader(fr);
				
				try {
					String cadena = br.readLine();
					while ((cadena = br.readLine()) != null) {
						System.out.println(cadena);
					}
					
					br.close();
					fr.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			} else {
				FileReader fr = new FileReader(nombre + ".txt");
				BufferedReader br = new BufferedReader(fr);

				try {
					String cadena = br.readLine();
					while ((cadena = br.readLine()) != null) {
						System.out.println(cadena);
					}
					
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
