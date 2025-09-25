package ficheros.tarea2.ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestionFicheroA {
	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("Ejercicio1.txt");
			BufferedReader br=new BufferedReader(fr);
			
			String cadena;
			
			try {
				while((cadena=br.readLine())!=null) {
					System.out.println(cadena);
					
				}
				
				br.close();
				fr.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
