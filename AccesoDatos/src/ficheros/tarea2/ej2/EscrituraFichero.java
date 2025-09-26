package ficheros.tarea2.ej2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscrituraFichero {
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		
		try {
			FileWriter fw=new FileWriter("Ejercicio2.txt");
			PrintWriter pw=new PrintWriter(fw);
			String texto = "t";
			while(!texto.contains("exit")) {
				System.out.println("Dime que es lo que quieres escribir si quieres finalizar escribe la palabra exit en minuscula");
				 texto=entrada.nextLine();
				 if(texto.contains("exit")) {
					 System.out.println("Salimos del sistema");
					 break;
				 }
				pw.println(texto);
				pw.flush();
			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
