package ficheros.tarea4;

import java.time.LocalDate;

/**
 * @author Ayoub
 * @version 1.0
 * @since 2025
 */
public class Alumno {
	private String nombre, apellido, ciclo, curso, grupo;
	private char genero;
	private LocalDate fecha_nacimiento;
	private int nia;

	public Alumno(String nombre, String apellido, String ciclo, String curso, String grupo, char genero,
			LocalDate fecha_nacimiento, int nia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nia = nia;
	}
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}
/**
 * 
 */
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", ciclo=" + ciclo + ", curso=" + curso
				+ ", grupo=" + grupo + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", nia=" + nia
				+ "]";
	}

public void setFechaNacimiento(LocalDate localDate) {
	// TODO Auto-generated method stub
	
}

}
