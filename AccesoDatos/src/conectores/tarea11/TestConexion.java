package conectores.tarea11;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
    	final String DB_URL = "jdbc:mysql://127.0.0.1:3306/alumno_ayoub?useSSL=false&serverTimezone=UTC";
    	final String USER = "root";
    	final String PASS = "(9r4tePrP7)";

    


        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Conexión OK");
        } catch (Exception e) {
            System.err.println("Error de conexión");
            e.printStackTrace();
        }
    }
}

