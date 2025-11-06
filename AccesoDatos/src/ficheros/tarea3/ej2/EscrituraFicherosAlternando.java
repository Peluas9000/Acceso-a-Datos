package ficheros.tarea3.ej2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscrituraFicherosAlternando {
	public static void main(String[] args) {
		try {
			ArrayList<String> lista1=new ArrayList<String>();
			ArrayList<String> lista2=new ArrayList<String>();

			FileReader fr1=new FileReader("Ejercicio3A.txt");
			BufferedReader br1=new BufferedReader(fr1);
			
				String cadena1=br1.readLine();
				while((cadena1=br1.readLine())!=null) {
					lista1.add(cadena1);
				}
			
				br1.close();
				fr1.close();
			FileReader fr2=new FileReader("Ejercicio3B.txt");
			BufferedReader br2=new BufferedReader(fr2);
			
			String cadena2=br2.readLine();
			while((cadena2=br2.readLine())!=null) {
				lista2.add(cadena2);
			}
			br2.close();
			fr2.close();
			
			ArrayList<String> lista=new ArrayList<String>();

			FileWriter fw=new FileWriter("Ejercicio3.txt");                         
			PrintWriter pw=new PrintWriter(fw);
			int cont=0;
			while(cont<lista1.size()||cont<lista2.size()) {
				if(cont<lista1.size()) {
					lista.add(lista1.get(cont)); 	
				}
				if(cont<lista2.size()){
					lista.add(lista2.get(cont));	
				}
				cont++;
			}
			
			for(String p:lista) {
				pw.println(p);
			}
			
			System.out.println("Escritura del ej hecho");
			
			
			pw.flush();
			System.out.println("Mostramos el ficheor final con frases intercaladas");
			
			FileReader fr=new FileReader("Ejercicio3.txt");
			BufferedReader br=new BufferedReader(fr);
			
			String cadena =br.readLine();
			while((cadena=br.readLine())!=null) {
				System.out.println(cadena);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
