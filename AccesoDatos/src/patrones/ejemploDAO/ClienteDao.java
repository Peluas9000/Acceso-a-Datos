package patrones.ejemploDAO;


import java.util.ArrayList;

public interface ClienteDao {

	public Cliente obtenerPorId(int id);

	public ArrayList<Cliente> obtenerTodos();

	public boolean eliminar(int id);
}
