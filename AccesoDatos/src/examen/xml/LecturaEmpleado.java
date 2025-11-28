package examen.xml;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Asegúrate de tener tu clase Empleado importada o en el mismo paquete
import examen.Empleado;
public class LecturaEmpleado {
 


	    public static void main(String[] args) {
	        List<Empleado> listaRecuperada = new ArrayList<>();

	        try {
	            // 1. FACTORY Y BUILDER
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // [cite: 482]
	            DocumentBuilder builder = factory.newDocumentBuilder(); // [cite: 483]

	            // 2. PARSEAR (Cargar XML) Y NORMALIZAR
	            File archivo = new File("EmpleadosObjetos.xml");
	            Document document = builder.parse(archivo); // 
	            document.getDocumentElement().normalize(); // 

	            // 3. OBTENER LISTA DE NODOS <empleado>
	            NodeList nodosEmpleados = document.getElementsByTagName("empleado"); // 
	            System.out.println("Empleados encontrados: " + nodosEmpleados.getLength());

	            // 4. RECORRER Y RECONSTRUIR OBJETOS
	            for (int i = 0; i < nodosEmpleados.getLength(); i++) {
	                Node nodo = nodosEmpleados.item(i); // [cite: 492]

	                // Verificar que sea un Elemento (etiqueta) y no texto vacío
	                if (nodo.getNodeType() == Node.ELEMENT_NODE) { // [cite: 493]
	                    Element elemento = (Element) nodo; // 

	                    // --- EXTRACCIÓN DE DATOS USANDO MÉTODO AUXILIAR ---
	                    String nombre = getContenido("nombre", elemento);
	                    String apellido = getContenido("apellido", elemento);
	                    String fechaStr = getContenido("fecha", elemento);
	                    String salarioStr = getContenido("salario", elemento);

	                    // --- CONVERSIÓN DE TIPOS (IMPORTANTE PARA EXAMEN) ---
	                    
	                    // 1. Parsear Salario (String -> Double)
	                    double salario = Double.parseDouble(salarioStr);

	                    // 2. Parsear Fecha (String -> LocalDate)
	                    // LocalDate.parse() entiende el formato ISO "2010-11-19" automáticamente
	                    LocalDate fecha = LocalDate.parse(fechaStr);

	                    // --- CREAR OBJETO Y AÑADIR A LISTA ---
	                    Empleado emp = new Empleado(nombre, apellido, fecha, salario);
	                    listaRecuperada.add(emp);
	                }
	            }

	            // 5. COMPROBACIÓN: MOSTRAR LA LISTA JAVA
	            System.out.println("\n--- LISTA JAVA RECONSTRUIDA ---");
	            for (Empleado e : listaRecuperada) {
	                System.out.println(e.toString()); // Asumiendo que tienes un toString() bonito
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // --- MÉTODO AUXILIAR PARA LEER (MUY ÚTIL EN EXAMEN) ---
	    // Recibe la etiqueta que buscas (ej: "nombre") y el elemento padre (el empleado actual)
	    private static String getContenido(String etiqueta, Element elementoPadre) {
	        // 1. Obtiene la lista de etiquetas con ese nombre dentro del padre
	        // 2. Coge la primera (.item(0))
	        // 3. Saca el texto (.getTextContent())
	        return elementoPadre.getElementsByTagName(etiqueta).item(0).getTextContent(); // [cite: 497]
	    
	}
}
