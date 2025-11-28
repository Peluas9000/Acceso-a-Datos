package examen;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Empleado implements Serializable{
	private static final long serialVersionUID=1L;
	private String nombre,apellido;
	private LocalDate fecha_alta;
	private double salario;
	
	public Empleado(String nombre, String apellido, LocalDate fecha_alta, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_alta = fecha_alta;
		this.salario = salario;
	}
	public Empleado(String nombre, String apellido, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
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
	public LocalDate getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", fecha_alta=" + fecha_alta + ", salario="
				+ salario + "]";
	}
	
	

}
