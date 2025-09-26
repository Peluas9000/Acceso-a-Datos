package ficheros.tarea2.ej1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class GestionFicherosB {

	


		public static void main(String[] args) {
			try {
				Scanner entrada=new Scanner(System.in);
				System.out.println("Dime el nombre del fichro sin la extension txt: ");
				String nombre=entrada.next();
				System.out.println("Dime si es relativa o absoluta la ruta");
				String tipo=entrada.next();
				if(tipo.equalsIgnoreCase("absoluta")) {
					System.out.println("Dime la ruta completa para llegar al archivo");
					String absoluta=entrada.next();
					
					FileReader fr=new FileReader(absoluta+nombre+".txt");
					BufferedReader br=new BufferedReader(fr);
				}else {
					FileReader fr=new FileReader(nombre+".txt");
					BufferedReader br=new BufferedReader(fr);
					
					String cadena;
					try {
						cadena = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
					
					
					
				
				
				
				
				
				
		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}

	}


