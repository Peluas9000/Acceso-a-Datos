package examen.xml;


	import java.io.File;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.List;
	import javax.xml.parsers.*;
	import javax.xml.transform.*;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import org.w3c.dom.*;
	import examen.Empleado;
	// Asegúrate de importar tu clase modelo Empleado
	// import examen.xml.lectura.Empleado; 

	public class CrearEmpleado {

	    public static void main(String[] args) {
	        
	        // --- PASO 1: PREPARAR LOS DATOS (Convertir Arrays a Objetos) ---
	        // Estos son los datos que me diste:
	        String[] nombres = {"Ayoub", "Guille", "Pablo"};
	        String[] apellidos = {"FERNANDEZ", "GIL", "LOPEZ"};
	        LocalDate[] fechas = {
	            LocalDate.of(2010, 11, 12),
	            LocalDate.of(2000, 12, 13),
	            LocalDate.of(2015, 9, 1)
	        };
	        double[] salarios = {1000.50, 2400.50, 2000.00};

	        // Creamos la lista y la llenamos con un bucle simple
	        List<examen.Empleado> listaEmpleados = new ArrayList<>();
	        for (int i = 0; i < nombres.length; i++) {
	            // Asumo que tu constructor es: (nombre, apellido, fecha, salario)
	            listaEmpleados.add(new Empleado(nombres[i], apellidos[i], fechas[i], salarios[i]));
	        }

	        // --- PASO 2: GENERAR EL XML (DOM) ---
	        try {
	            // A. Factory y Builder
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            DOMImplementation implementation = builder.getDOMImplementation();

	            // B. Crear Documento y Raíz
	            Document document = implementation.createDocument(null, "Empleados", null);
	            document.setXmlVersion("1.0");

	            // C. Recorrer la LISTA DE OBJETOS
	            for (Empleado emp : listaEmpleados) {
	                // 1. Crear nodo <empleado>
	                Element nodoEmpleado = document.createElement("empleado");
	                
	                // 2. Pegarlo a la raíz (<Empleados>)
	                document.getDocumentElement().appendChild(nodoEmpleado);

	                // 3. LLAMADA AL MÉTODO "JEFE" (Pasa el objeto entero)
	                crearElementoEmpleado(document, nodoEmpleado, emp);
	            }

	            // D. Guardar (Transformer)
	            Source source = new DOMSource(document);
	            Result result = new StreamResult(new File("EmpleadosFinal.xml"));
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Formato bonito
	            transformer.transform(source, result);
	            
	            System.out.println("¡XML generado con éxito! Revisa 'EmpleadosFinal.xml'");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // --- MÉTODO "JEFE" (Recibe el Objeto Empleado) ---
	    // Decide QUÉ campos del objeto se guardan y cómo se llaman las etiquetas
	    private static void crearElementoEmpleado(Document doc, Element padre, Empleado emp) {
	        crearEtiquetaSimple("nombre", emp.getNombre(), padre, doc);
	        crearEtiquetaSimple("apellido", emp.getApellido(), padre, doc);
	        
	        // IMPORTANTE: Convertir LocalDate a String
	        crearEtiquetaSimple("fechaNacimiento", emp.getFecha_alta().toString(), padre, doc);
	        
	        // IMPORTANTE: Convertir double a String
	        crearEtiquetaSimple("salario", Double.toString(emp.getSalario()), padre, doc);
	    }

	    // --- MÉTODO "OBRERO" (Crea nodos de texto) ---
	    // Hace el trabajo sucio de crear etiqueta + texto + append
	    private static void crearEtiquetaSimple(String etiqueta, String valor, Element padre, Document doc) {
	        Element elem = doc.createElement(etiqueta); // Crea caja
	        Text text = doc.createTextNode(valor);      // Crea producto
	        elem.appendChild(text);                     // Mete producto en caja
	        padre.appendChild(elem);                    // Pone caja en estantería
	    }
	}



