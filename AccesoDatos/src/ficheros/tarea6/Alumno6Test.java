package ficheros.tarea6;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ficheros.tarea6.Alumno6;

public class Alumno6Test {

    private Alumno6 alumno;

    // Se ejecuta antes de cada test: inicializamos el objeto
    @BeforeEach
    public void setUp() {
        alumno = new Alumno6(
                "Ayoub", "Ben Jaddi", "DAM", "2º", "A",
                12345, "M", LocalDate.of(2005, 5, 10)
        );
    }

    @Test
    public void testConstructorYGetters() {
        assertEquals("Ayoub", alumno.getNombre());
        assertEquals("Ben Jaddi", alumno.getApellidos());
        assertEquals("DAM", alumno.getCiclo());
        assertEquals("2º", alumno.getCurso());
        assertEquals("A", alumno.getGrupo());
        assertEquals(12345, alumno.getNia());
        assertEquals("M", alumno.getGenero());
        assertEquals(LocalDate.of(2005, 5, 10), alumno.getFecha_nacimiento());
    }

    @Test
    public void testSetters() {
        alumno.setNombre("Sara");
        alumno.setApellidos("López");
        alumno.setCiclo("DAW");
        alumno.setCurso("1º");
        alumno.setGrupo("B");
        alumno.setNia(9999);
        alumno.setGenero("F");
        alumno.setFecha_nacimiento(LocalDate.of(2004, 3, 15));

        assertEquals("Sara", alumno.getNombre());
        assertEquals("López", alumno.getApellidos());
        assertEquals("DAW", alumno.getCiclo());
        assertEquals("1º", alumno.getCurso());
        assertEquals("B", alumno.getGrupo());
        assertEquals(9999, alumno.getNia());
        assertEquals("F", alumno.getGenero());
        assertEquals(LocalDate.of(2004, 3, 15), alumno.getFecha_nacimiento());
    }

    @Test
    public void testToString() {
        String texto = alumno.toString();
        assertTrue(texto.contains("Ayoub"));
        assertTrue(texto.contains("DAM"));
        assertTrue(texto.contains("12345"));
        assertTrue(texto.startsWith("Alumno ["));
    }
}
