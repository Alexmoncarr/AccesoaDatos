package ficheroXML;

import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear el documento XML
            Document doc = docBuilder.newDocument();

            // Elemento raíz
            Element persona = doc.createElement("persona");
            persona.setAttribute("profesion", "cantante");
            doc.appendChild(persona);

            // Elemento nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Elsa"));
            persona.appendChild(nombre);

            // Elemento mujer
            Element mujer = doc.createElement("mujer");
            persona.appendChild(mujer);

            // Elemento fecha_de_nacimiento
            Element fechaNacimiento = doc.createElement("fecha_de_nacimiento");
            persona.appendChild(fechaNacimiento);

            // Elemento dia
            Element dia = doc.createElement("dia");
            dia.appendChild(doc.createTextNode("18"));
            fechaNacimiento.appendChild(dia);

            // Elemento mes
            Element mes = doc.createElement("mes");
            mes.appendChild(doc.createTextNode("6"));
            fechaNacimiento.appendChild(mes);

            // Elemento año
            Element año = doc.createElement("año");
            año.appendChild(doc.createTextNode("1996"));
            fechaNacimiento.appendChild(año);

            // Elemento ciudad
            Element ciudad = doc.createElement("ciudad");
            ciudad.appendChild(doc.createTextNode("Pamplona"));
            persona.appendChild(ciudad);

            // Escribir el contenido en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(new File("persona.xml")));

            // Transformar y guardar el archivo XML
            transformer.transform(source, result);

            System.out.println("Archivo XML creado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
