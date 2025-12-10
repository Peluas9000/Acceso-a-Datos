package patrones.ejemploDAO;

import java.awt.Taskbar.State;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MysqlClienteDao implements ClienteDao {
	// Constantes de conexión (En una aplicación real, irían en un archivo de
	// configuración)
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String CLAVE = "tu_clave";

	// Método de utilidad para la conexión
	private Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, CLAVE);
	}

	@Override
	public Cliente obtenerPorId(int id) {
		Cliente c = null;
		try {
		
			Statement sentencia = conectar().createStatement();
			String sql = "SELECT id,nombre,email FROM clientes WHERE id="+id;
			ResultSet resultado = sentencia.executeQuery(sql);
			boolean existe = false;
			while (resultado.next()) {
				existe = true;
				int identificador = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String email = resultado.getString("email");
				
				System.out.printf("id %d| nombre %s |email % ", identificador, nombre, email);
				c=new Cliente(identificador,nombre,email);
			}

			resultado.close();
			if (existe) {
				System.out.println("Consulta realizada");
			} else {
				System.out.println("No existe en la base de datos la consulta realizada");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public ArrayList<Cliente> obtenerTodos() {

		Cliente c = null;
		ArrayList<Cliente> lista=new ArrayList<>();
		try {
		
			Statement sentencia = conectar().createStatement();
			String sql = "SELECT id,nombre,email FROM clientes";
			ResultSet resultado = sentencia.executeQuery(sql);
			boolean existe = false;
			while (resultado.next()) {
				existe = true;
				int identificador = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String email = resultado.getString("email");
				
				System.out.printf("id %d| nombre %s |email % ", identificador, nombre, email);
				c=new Cliente(identificador,nombre,email);
				lista.add(c);
			}

			resultado.close();
			if (existe) {
				System.out.println("Consulta realizada");
			} else {
				System.out.println("No existe en la base de datos la consulta realizada");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	
		}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
