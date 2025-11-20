package conectores.tarea11;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ficheros.tarea4.Alumno;

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

	public void actualizarAlumno(Connection c) {
		
		
		try {
			
			Scanner entrada=new Scanner(System.in);
			
			System.out.println("Dime el NIA del alumno a eliminar");
			int nia=entrada.nextInt();
			entrada.nextLine();
			
			System.out.println("Dime el nuevo nombre de alumno ");
			String nombre_nuevo=entrada.nextLine();
			
				
			String sql="UPDATE alumno SET nombre= ? WHERE nia= ?";
			
			PreparedStatement sentencia= c.prepareStatement(sql);   
			
			sentencia.setString(1, nombre_nuevo);
			sentencia.setInt(2,nia);
			
			int filas =sentencia.executeUpdate();
			
			if(filas>0) {
				System.out.println("Nombre actualizado correctamente");
			}else {
				System.out.println("No existe ningun alumno con ese nia ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void eliminarAlumnoPorNia(Connection c) {
		
		
		
		try {
			Scanner entrada=new Scanner(System.in);
			
			System.out.println("Dime el nia del alumno a eliminar");
			int nia=entrada.nextInt();
			entrada.nextLine();
			
			String sql="DELETE FROM alumno WHERE nia=?";
			PreparedStatement sentencia= c.prepareStatement(sql);
			
			sentencia.setInt(1, nia);
			int finalizado =sentencia.executeUpdate();
			
			if(finalizado>0) {
				System.out.println("Se elimino correctamente el alumno con nia :"+nia );
			}else {
				System.out.println("No existe nigun alumno con ese nia");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void eliminarAlumnoPorApellido(Connection c) {

		try {
			
			Scanner entrada=new Scanner(System.in);
			
			System.out.println("Se van ha elimnar los alumnos con la cadena dada en el apellido");
			String dada="dada";
			
			
			String sql="DELETE FROM alumno WHERE apellidos LIKE ?";
			PreparedStatement sentencia= c.prepareStatement(sql);
			
			sentencia.setString(1,dada);
			int finalizado =sentencia.executeUpdate();
			
			if(finalizado>0) {
				System.out.println("Se elimino correctamente el alumno con la cadena dada en su apellido" );
			}else {
				System.out.println("No existe nigun alumno con ese cadena en su apellido");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
	public void guardarAlumnosEnCSV(Connection c) {

	    String sql = "SELECT * FROM alumno";

	    try (Statement st = c.createStatement();
	         ResultSet rs = st.executeQuery(sql);
	         FileWriter fw = new FileWriter("alumnos.csv")) {

	        while (rs.next()) {
	            int nia = rs.getInt("nia");
	            String nombre = rs.getString("nombre");
	            String apellidos = rs.getString("apellidos");
	            String genero = rs.getString("genero");
	            String fecha = rs.getDate("fecha_nacimiento").toString();
	            String ciclo = rs.getString("ciclo");
	            String curso = rs.getString("curso");
	            String grupo = rs.getString("grupo");

	            // Guardamos UNA línea en CSV
	            fw.write(nia + ";" + nombre + ";" + apellidos + ";" + genero + ";" + fecha + ";" +
	                     ciclo + ";" + curso + ";" + grupo + "\n");
	        }

	        System.out.println("Fichero CSV creado correctamente.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public void leerCSVyGuardarEnBD(Connection c) {

	    try (Scanner sc = new Scanner(new File("Ejercicio1.txt"))) {

	        String sql = "INSERT INTO alumno(nia, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, grupo) VALUES (?,?,?,?,?,?,?,?)";
	        PreparedStatement ps = c.prepareStatement(sql);

	        while (sc.hasNextLine()) {
	            String linea = sc.nextLine();
	            String[] datos = linea.split(";");

	            int nia = Integer.parseInt(datos[0]);
	            String nombre = datos[1];
	            String apellidos = datos[2];
	            String genero = datos[3];
	            LocalDate fecha = LocalDate.parse(datos[4]);
	            String ciclo = datos[5];
	            String curso = datos[6];
	            String grupo = datos[7];
	            
	            ps.setInt(1, nia);
	            ps.setString(2, nombre);
	            ps.setString(3, apellidos);
	            ps.setString(4, genero);
	            ps.setDate(5, java.sql.Date.valueOf(fecha));
	            ps.setString(6, ciclo);
	            ps.setString(7, curso);
	            ps.setString(8, grupo);

	            ps.executeUpdate();
	            
	        }

	        System.out.println("Fichero txt leído y alumnos insertados en la BD.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void exportarAlumnosAJson(Connection c, String rutaFichero) {
		
	    String sql = "SELECT * FROM alumno";
	    try (Statement st = c.createStatement();
	         ResultSet rs = st.executeQuery(sql);
	         FileWriter fw = new FileWriter(rutaFichero)) {

	        List<Alumno> lista = new ArrayList<>();
	        while (rs.next()) {
	            Alumno a = new Alumno();
	            a.setNia(rs.getInt("nia"));
	            a.setNombre(rs.getString("nombre"));
	            a.setApellido(rs.getString("apellidos"));
	            a.setGenero(rs.getString("genero").charAt(0));
	            java.sql.Date d = rs.getDate("fecha_nacimiento");
	            if (d != null) a.setFechaNacimiento(d.toLocalDate());
	            a.setCiclo(rs.getString("ciclo"));
	            a.setCurso(rs.getString("curso"));
	            a.setGrupo(rs.getString("grupo"));
	            lista.add(a);
	        }

	        Gson gson = new GsonBuilder()
	                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
	                .setPrettyPrinting()
	                .create();

	        gson.toJson(lista, fw);
	        System.out.println("Exportado a JSON: " + rutaFichero);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	

	public void importarJsonABase(Connection c, String rutaFichero) {
	    try (FileReader fr = new FileReader(rutaFichero)) {
	        Gson gson = new GsonBuilder()
	                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
	                .create();

	        Type tipoLista = new TypeToken<List<Alumno>>(){}.getType();
	        List<Alumno> lista = gson.fromJson(fr, tipoLista);

	        String sql = "INSERT INTO alumno(nia,nombre,apellidos,genero,fecha_nacimiento,ciclo,curso,grupo) VALUES (?,?,?,?,?,?,?,?)";
	        try (PreparedStatement ps = c.prepareStatement(sql)) {
	            int insertados = 0;
	            for (Alumno a : lista) {
	                ps.setInt(1, a.getNia());
	                ps.setString(2, a.getNombre());
	                ps.setString(3, a.getApellido());
	                ps.setString(4, String.valueOf(a.getGenero()));
	                if (a.getFecha_nacimiento() != null)
	                    ps.setDate(5, java.sql.Date.valueOf(a.getFecha_nacimiento()));
	                else
	                    ps.setNull(5, java.sql.Types.DATE);
	                ps.setString(6, a.getCiclo());
	                ps.setString(7, a.getCurso());
	                ps.setString(8, a.getGrupo());
	                try {
	                    insertados += ps.executeUpdate();
	                } catch (SQLException ex) {
	                    // PK duplicada o error: muestra y sigue
	                    System.err.println("No insertado NIA=" + a.getNia() + " -> " + ex.getMessage());
	                }
	            }
	            System.out.println("Insertados desde JSON: " + insertados);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



	
	
	
}
