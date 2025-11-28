package examen.txt;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import examen.Empleado;

public class LecturaEscritura {
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		int opcion=0;
		ArrayList<Empleado> listEmpleado=new ArrayList<>();
		do {
			System.out.println("Dime 1 escribir | 2 leer | 3. Fin");
			 opcion=entrada.nextInt();
		switch(opcion) {
		case 1:
			Empleado e1=new Empleado("Ayoub","BenJaddi",LocalDate.of(2010, 11, 19),2000.0);
			listEmpleado.add(e1);
			File f=new File("empleados.dat");
			try(ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(f))){
				for(Empleado e:listEmpleado) {
					oo.writeObject(e);
				}
				
				System.out.println("Empleado guardado");
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			
		case 2:
			System.out.println("Dime que fichenro binario quieres leer con la extension .dat ");
			String fichero=entrada.next();
			try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream(fichero))){
				
				while(true) {
					Empleado emp=(Empleado) oi.readObject();
					System.out.println(emp.toString());
				}
				
			}catch(EOFException e) {
				System.out.println("Lectura finalizada");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException a) {
				// TODO Auto-generated catch block
				System.out.println("lectura finalizada");
			}
		
			
			
			
			
			
			break;
		}
		}while(opcion<3);
		
		
	
	}

}
