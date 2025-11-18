package conectores.tarea11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class CRUD extends Modularizacion {
	    public static void main(String[] args) {
	    	 Scanner entrada = new Scanner(System.in);
	         Modularizacion m = new Modularizacion();
	        
	         final String DB_URL = "jdbc:mysql://127.0.0.1:3306/alumno_ayoub";
	        final String USER = "root";
	        final String PASS = "(9r4tePrP7)";
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("No conectado el driver");
	        }

	        try (Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS)) {

	           

	            int num;
	            do {
	            	System.out.println("1.Insertar un nuevo alumno.\r\n" + "2.Mostar todos los alumnos (en consola).\r\n"
	        				+ "3.Guardar todos los alumnos en un fichero (tú eliges el formato del\r\n"
	        				+ "4.fichero, pero no puede ser XML ni JSON).\r\n"
	        				+ "5. Leer alumnos de un fichero (con el formato anterior), y guardarlo\r\n" + "en una BD.\r\n"
	        				+ " 6.Modificar el nombre de un alumno guardado en la base de datos\r\n"
	        				+ "a partir de su Primary Key (PK).\r\n" + "7. Eliminar un alumno a partir de su (PK).\r\n"
	        				+ "8. Eliminar los alumnos que su apellido contengan la palabra dada\r\n"
	        				+ "por el usuario.\r\n" + "9. Guardar todos los alumnos en un fichero XML o JSON.\r\n"
	        				+ "10. Leer un fichero XML o JSON de alumnos (con en formato\r\n"
	        				+ "anterior) y guardarlos en la BD./n" + "11.Salir del programa");

	        		 num = entrada.nextInt();
	        		

	                switch (num) {
	                    case 1:
	                        m.insertarAlumno(conexion);
	                        break;
	                    case 2:
	                        m.mostrarTodosAlumno(conexion);
	                        break;
	                }

	            } while (num !=11);

	            System.out.println("Saliendo del programa...");
	            

	        } catch (SQLException e) {
	            System.err.println("Error conexion");
	        }
	    }



}
