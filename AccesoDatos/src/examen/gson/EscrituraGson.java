package examen.gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import examen.Empleado;
public class EscrituraGson {
	public static void main(String[] args) {
       
		
		try(FileWriter fw=new FileWriter("alumnos.json")){
			ArrayList<Empleado> lista = new ArrayList<>();
	        lista.add(new Empleado("Ayoub", "Fernandez", 1000.50));
	        lista.add(new Empleado("Guille", "Gil",  2400.50));

			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			
			gson.toJson(lista,fw);
			System.out.println("JSON generado correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
