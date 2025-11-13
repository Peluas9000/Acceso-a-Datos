package ficheros.tarea10B;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Adaptador para permitir a Gson leer/escribir LocalDate sin errores.
 */
public class LocalDateAdapter extends TypeAdapter<LocalDate> {



    @Override
    public LocalDate read(JsonReader in) throws IOException {
        // Leemos el texto y lo convertimos de nuevo a LocalDate
        return LocalDate.parse(in.nextString());
    }

	@Override
	public void write(JsonWriter arg0, LocalDate arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}

