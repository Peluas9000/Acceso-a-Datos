package ficheros.tarea7;

import java.time.LocalDate;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ficheros.tarea1.Alumno;

public class XmlAlumnos {
	
	protected void  generarXML(String nombre) {
		ArrayList<Alumno> lista=new ArrayList<>();
		Alumno a1 = new Alumno("Ayoub", "Gutierrez", "dam", "segundo", "D", 1256, "H", LocalDate.of(2005, 11, 19));
		Alumno a2 = new Alumno("Pilar", "Santos", "dam", "segundo", "A", 5322, "M", LocalDate.of(2000, 12, 12));
		Alumno a3 = new Alumno("Guillermo", "Garcia", "ASIR", "PRIMERO", "B", 321, "H", LocalDate.of(1995, 1, 30));
		Alumno a4 = new Alumno("Guillermo", "Chueca", "ADE", "segundo", "A", 7854, "H", LocalDate.of(2010, 3, 20));
		Alumno a5 = new Alumno("Miguel", "Peña", "DAW", "PRIMERO", "C", 243231, "H", LocalDate.of(2004, 04, 04));

		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a5);

		//Creamos la factoria para generar documentos XML
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			DOMImplementation implementation =builder.getDOMImplementation();
			//Crear documento XML vacio
			Document document=implementation.createDocument(null,"Alumnos", null);
			document.setXmlVersion("1.0");
			
			for(Alumno a:lista) {
				//Creamos el nodo 
				Element alumno=document.createElement("alumno");
				//Añadimos el nodo 
				document.getDocumentElement().appendChild(alumno);
				
				crearElementoAlumno(document, alumno, a);
				
			}
			
			//Generamos el fichero XML QUE ESTABA EN MEMORIA 
			
			Source source =new DOMSource(document);
			Result result=new StreamResult(new java.io.File(nombre));
			Transformer transformer= TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	
		
	}
	
	protected void crearElementoAlumno(Document documento,Element alumnoElement,Alumno alumno) {
		crearElementoAlumno("NIA",Integer.toString(alumno.getNia()),alumnoElement,documento);
		crearElementoAlumno("nombre",alumno.getNombre(), alumnoElement, documento);
		crearElementoAlumno("apellidos",alumno.getApellidos(), alumnoElement, documento);
		crearElementoAlumno("genero",alumno.getGenero(), alumnoElement, documento);
		crearElementoAlumno("fecha_nacimiento",alumno.getFecha_nacimiento().toString(), alumnoElement, documento);
		crearElementoAlumno("ciclo",alumno.getCiclo(), alumnoElement, documento);
		crearElementoAlumno("curso",alumno.getCurso(), alumnoElement, documento);
		crearElementoAlumno("grupo",alumno.getGrupo(), alumnoElement, documento);

	}
	protected  void crearElementoAlumno(String datoAlumno,String valor,Element alumnos,Document documento) {
		Element elem=documento.createElement(datoAlumno);
		Text text=documento.createTextNode(valor);
		elem.appendChild(text);
		alumnos.appendChild(elem);
		
	}
	
	
	public static void main(String[] args) {
		XmlAlumnos a=new XmlAlumnos();
		
		a.generarXML("AlumnosDOMObjetos");
		
	}
	
}

