package patrones.ejemploDAO;

public class Cliente {
	private int id;
	private String nombre, email;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
