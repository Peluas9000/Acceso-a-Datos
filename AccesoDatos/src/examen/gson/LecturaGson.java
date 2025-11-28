package examen.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; // ¡IMPORTANTE!

import examen.Empleado;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LecturaGson {
    public static void main(String[] args) {
        
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("empleados.json")) {
            
            // 1. DEFINIR EL TIPO DE DATO (La parte difícil)
            // Tienes que decirle: "Oye, esto es un ArrayList de Empleados"
            // Memoriza esta línea: new TypeToken< TIPO_DE_LISTA >(){}.getType();
            Type tipoLista = new TypeToken<ArrayList<Empleado>>(){}.getType();
            
            // 2. LEER Y CONVERTIR
            List<Empleado> listaLeida = gson.fromJson(reader, tipoLista);

            // 3. COMPROBAR
            for (Empleado e : listaLeida) {
                System.out.println(e); 
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}