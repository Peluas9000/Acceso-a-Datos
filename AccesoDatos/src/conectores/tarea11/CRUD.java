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
		final String DB_URL = "jdbc:mysql://localhost:3306/alumno_ayoub?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "9r4tePrP7"; // Tu clave
		Modularizacion m = new Modularizacion();// Metodos modularizados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("No conectado el driver");
		}
		try (Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement sentencia = conexion.createStatement();) {
			Scanner entrada = new Scanner(System.in);

			
			int num;
			do {
				 num=m.mostrarOpcionMenu();
				switch (num) {
				case 1:
					m.insertarAlumno(conexion);

					break;

				case 2:
					m.mostrarTodosAlumno(conexion);
					break;

				}

			} while (num != 11);
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
