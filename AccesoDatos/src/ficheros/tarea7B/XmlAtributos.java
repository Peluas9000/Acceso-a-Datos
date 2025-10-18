package ficheros.tarea7B;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ficheros.tarea1.Alumno;
import ficheros.tarea7.XmlAlumnos;

public class XmlAtributos extends XmlAlumnos {

	@Override
    protected void crearElementoAlumno(Document documento, Element alumnoElement, Alumno alumno) {
        alumnoElement.setAttribute("NIA", Integer.toString(alumno.getNia()));
        alumnoElement.setAttribute("nombre", alumno.getNombre());
        alumnoElement.setAttribute("apellidos", alumno.getApellidos());
        alumnoElement.setAttribute("genero", alumno.getGenero());
        alumnoElement.setAttribute("fecha_nacimiento", alumno.getFecha_nacimiento().toString());
        alumnoElement.setAttribute("ciclo", alumno.getCiclo());
        alumnoElement.setAttribute("curso", alumno.getCurso());
        alumnoElement.setAttribute("grupo", alumno.getGrupo());
    }

    public static void main(String[] args) {
        XmlAtributos generador = new XmlAtributos();
        generador.generarXML("AlumnosAtributos.xml");
    }
}
