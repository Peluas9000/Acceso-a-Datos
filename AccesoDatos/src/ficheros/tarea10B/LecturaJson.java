package ficheros.tarea10B;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ficheros.tarea4.Alumno;

public class LecturaJson {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
		
        Type tipoLista = new TypeToken<List<Alumno>>(){}.getType();
        
		try(FileReader fr=new FileReader("alumnos.json")){
			List<Alumno> lista=gson.fromJson(fr,tipoLista);
			
			for(Alumno a:lista) {
				System.out.println("Nombre :"+a.getNombre());
				System.out.println("Apellidos"+a.getApellido());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
