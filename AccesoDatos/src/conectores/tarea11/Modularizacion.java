package conectores.tarea11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Modularizacion {
	
	
	
	public Modularizacion() {
		super();
	}
	
	public Modularizacion(Scanner entrada) {
		// TODO Auto-generated constructor stub
	}

	
	

	public void insertarAlumno(Connection c) {
		
		try {
			Scanner entrada=new Scanner(System.in);
			System.out.print("NIA: ");
			int niaEdit = entrada.nextInt();
			entrada.nextLine(); // limpiar buffer
			System.out.print("Nombre: ");
			String nombreEdit = entrada.nextLine();
			System.out.print("Apellidos: ");
			String apellidosEdit = entrada.nextLine();
			System.out.print("Género (H/M): ");
			char generoEdit = entrada.nextLine().toUpperCase().charAt(0);
			System.out.println("Dime el año de nacimiento");
			int anioEdit = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Dime el mes de nacimiento");
			int mesEdit = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Dime el dia de nacimiento");
			int diaEdit = entrada.nextInt();
			entrada.nextLine();
			System.out.print("Ciclo: ");
			String cicloEdit = entrada.nextLine();
			System.out.print("Curso: ");
			String cursoEdit = entrada.nextLine();
			System.out.print("Grupo: ");
			String grupoEdit = entrada.nextLine();
			// Fecha final de nacimiento
			LocalDate fechaEdit = LocalDate.of(anioEdit, mesEdit, diaEdit);
			java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaEdit);

			String sql = "INSERT INTO alumno(nia,nombre,apellidos,genero,fecha_nacimiento,ciclo,curso,grupo) "
					+ "VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement resulatdoP = c.prepareStatement(sql);
			resulatdoP.setInt(1, niaEdit);
			resulatdoP.setString(2, nombreEdit);
			resulatdoP.setString(3, apellidosEdit);
			resulatdoP.setString(4, String.valueOf(generoEdit));
			resulatdoP.setDate(5, fechaSQL);
			resulatdoP.setString(6, cicloEdit);
			resulatdoP.setString(7, cursoEdit);
			resulatdoP.setString(8, grupoEdit);

			// 5. Ejecutar la MODIFICACIÓN: ¡CLAVE!
			int filasAfectadas;
			filasAfectadas = resulatdoP.executeUpdate();
			
			if (filasAfectadas > 0) {
				System.out.println(" Alumno insertado correctamente.");
			} else {
				System.out.println(" No se pudo insertar el alumno.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
	}
	
	
	public void mostrarTodosAlumno(Connection c) {
		
       
		try {
			 Statement sentencia = c.createStatement();
			System.out.println("----------ALUMNOS----------------------");
			 String sql="SELECT nia,nombre,apellidos FROM alumno ";
			 
			 ResultSet resultado=sentencia.executeQuery(sql);
			 boolean existe=false;
			 
			 while(resultado.next()) {
				 existe=true;
				 int nia=resultado.getInt("nia");
				 String nombre=resultado.getString("nombre");
				 String apellidos=resultado.getString("apellidos");
				 System.out.printf("nia: %d | nombre: %s | apellidos: %s",nia,nombre,apellidos);
				 System.out.println();
				 
			 }
			 
			 if(!existe) {
				 System.out.println("No hay nigun alumno ");
			 }
			 
			 resultado.close();
			 System.out.println("-------------------------------------------------------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	}

}
