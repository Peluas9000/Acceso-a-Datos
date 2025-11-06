              package ficheros.tarea3.ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LineaPar {
	public static void main(String[] args) {
	
		
		try {
			ArrayList<String> frases_par=new ArrayList<>();
			Scanner entrada=new Scanner(System.in);
			System.out.println("Dime el nombre del archivo sin la extension txt");
			String nombre=entrada.next();
			
			FileReader fr=new FileReader(nombre+".txt");
			BufferedReader br=new BufferedReader(fr);
			int cont=0;
			String cadena;
			try {
				cadena = br.readLine();
				
				while((cadena=br.readLine())!=null) {
					if(cont%2==0) {
						frases_par.add(cadena);
					}
				
				}
				br.close();
				fr.close();
				
				FileWriter fw=new FileWriter(nombre+".txt");
				PrintWriter pw=new PrintWriter(fw);
				for(String frases:frases_par) {
					pw.println(frases);
					
				}
				
				
				
			
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
