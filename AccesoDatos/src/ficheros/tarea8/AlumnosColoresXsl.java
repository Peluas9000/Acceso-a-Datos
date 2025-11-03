package ficheros.tarea8;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class AlumnosColoresXsl {
	public static void main(String[] args) {

        try {
            // Ficheros de entrada y salida
            Source xml = new StreamSource(new File("AlumnosDOMObjetos.xml"));
            Source xsl = new StreamSource(new File("alumnoColor.xsl"));
            Result html = new StreamResult(new File("AlumnosColorHTML.html"));

            // Aplicar la transformación
            Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
            transformer.transform(xml, html);

            System.out.println("HTML generado correctamente: AlumnosHTML.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
	}
}
