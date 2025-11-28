package ficheros.tarea4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ficheros.tarea1.Alumno;

public class GestionAlumnos {
	public static void main(String[] args) {
		DataInputStream di = null;
		DataOutputStream dp = null;
		try {
			Scanner entrada = new Scanner(System.in);
			ArrayList<Alumno> lista = new ArrayList<Alumno>();
			Alumno a1 = new Alumno("Ayoub", "Gutierrez", "dam", "segundo", "D", 1256, "H", LocalDate.of(2005, 11, 19));
			Alumno a2 = new Alumno("Pilar", "Santos", "dam", "segundo", "A", 5322, "M", LocalDate.of(2000, 12, 12));
			Alumno a3 = new Alumno("Guillermo", "Garcia", "ASIR", "PRIMERO", "B", 321, "H", LocalDate.of(1995, 1, 30));
			Alumno a4 = new Alumno("Guillermo", "Chueca", "ADE", "segundo", "A", 7854, "H", LocalDate.of(2010, 3, 20));
			Alumno a5 = new Alumno("Miguel", "Peña", "DAW", "PRIMERO", "C", 243231, "H", LocalDate.of(2004, 04, 04));

			lista.add(a1);
			lista.add(a2);
			lista.add(a3);
			lista.add(a4);
			lista.add(a5);

//			System.out.println("Dime el nombre del fichero sin la extension");
//			String fichero = entrada.next();
			System.out.println("Dime la ruta sin el nombre del fichero de ultima");
			String ruta = entrada.nextLine();

			// Escritura de los 5 alumnos
			dp = new DataOutputStream(new FileOutputStream(ruta));

			for (Alumno a : lista) {
				dp.writeInt(a.getNia());
				dp.writeUTF(a.getNombre());
				dp.writeUTF(a.getApellidos());
				dp.writeUTF(a.getCiclo());
				dp.writeUTF(a.getCurso());
				dp.writeUTF(a.getGrupo());
				dp.writeUTF(a.getGenero());
				dp.writeInt(a.getFecha_nacimiento().getYear());
				dp.writeInt(a.getFecha_nacimiento().getMonthValue());
				dp.writeInt(a.getFecha_nacimiento().getDayOfMonth());
			
			}
			
			//Lectura de los 5 alumnos 
			di=new DataInputStream(new FileInputStream(ruta));
			while(di.available()>0) {
				 int nia = di.readInt();
				    String nombre = di.readUTF();
				    String apellidos = di.readUTF();
				    String ciclo = di.readUTF();
				    String curso = di.readUTF();
				    String grupo = di.readUTF();
				    String genero = di.readUTF();
				    int year = di.readInt();
				    int month = di.readInt();
				    int day = di.readInt();
				    LocalDate fecha = LocalDate.of(year, month, day);

				    Alumno alumno = new Alumno(nombre, apellidos, ciclo, curso, grupo, nia, genero, fecha);
				    System.out.println(alumno); // si tienes toString()
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dp != null) {
				try {
					dp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

			if (di != null) {
				try {
					di.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
		}
	}
}
