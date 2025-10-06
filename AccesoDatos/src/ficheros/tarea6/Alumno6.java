package ficheros.tarea6;

import java.io.Serializable;
import java.time.LocalDate;

public class Alumno6 implements Serializable{
	

			private static final long serialVersionUID=1234810648321641274L;


			private String nombre,apellidos,ciclo,curso,grupo;
			private int nia;
			private String genero;
			private LocalDate fecha_nacimiento;
			//constructor
			public Alumno6(String nombre, String apellidos, String ciclo, String curso, String grupo, int nia,
					String genero, LocalDate fecha_nacimiento) {
				super();
				this.nombre = nombre;
				this.apellidos = apellidos;
				this.ciclo = ciclo;
				this.curso = curso;
				this.grupo = grupo;
				this.nia = nia;
				this.genero = genero;
				this.fecha_nacimiento = fecha_nacimiento;
			}
			
			

			//getters y setters 
			public String getNombre() {
				return nombre;
			}
			
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getApellidos() {
				return apellidos;
			}
			public void setApellidos(String apellidos) {
				this.apellidos = apellidos;
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
			public int getNia() {
				return nia;
			}
			public void setNia(int nia) {
				this.nia = nia;
			}
			public String getGenero() {
				return genero;
			}
			public void setGenero(String genero) {
				this.genero = genero;
			}
			public LocalDate getFecha_nacimiento() {
				return fecha_nacimiento;
			}
			public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
				this.fecha_nacimiento = fecha_nacimiento;
			}
			
			//toString 
			@Override
			public String toString() {
				return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", curso=" + curso
						+ ", grupo=" + grupo + ", nia=" + nia + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento
						+ "]";
			}
			
			
			
		}





