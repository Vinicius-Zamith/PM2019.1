package Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Main.GeradorMunicipio;

public class XmlReader {
	
	private static String xmlUrl;
	
	public XmlReader (String xmlUrl) {
		this.xmlUrl = xmlUrl;
	}

    public static String getXmlUrl() {
		return xmlUrl;
	}

	public void setXmlUrl(String xmlUrl) {
		this.xmlUrl = xmlUrl;
	}



	public void populandoHashMap() throws SAXException,
            IOException, ParserConfigurationException {

        File xmlFile = new File(getXmlUrl());
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Placemark");

        ArrayList<String> nomeMunicipios = new ArrayList<String>();
        ArrayList<String> codigoMunicipios = new ArrayList<String>();
        ArrayList<String> coordenadasMunicipios = new ArrayList<String>();

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            Element element = (Element) nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				String nomeMunicipio = element.getElementsByTagName("SimpleData").item(0).getTextContent();
				String codigoMunicipio = element.getElementsByTagName("SimpleData").item(1).getTextContent();
//				String coordenadasMunicipio = element.getElementsByTagName("coordinates").item(0).getTextContent();
				nomeMunicipios.add(nomeMunicipio);
				codigoMunicipios.add(codigoMunicipio);
				coordenadasMunicipios.add(juntarCoordenadas(element));
            }
        }
        
       GeradorMunicipio geradorMunicipio = new GeradorMunicipio(nomeMunicipios, codigoMunicipios, coordenadasMunicipios);
       geradorMunicipio.gerarMunicipio();
    }
	
	public String juntarCoordenadas(Element element) {
		NodeList listaPoligono = element.getElementsByTagName("Polygon");
		String coordenadas = "";

		for (int i = 0; i < listaPoligono.getLength(); i++) {
			Element polygon = (Element) listaPoligono.item(i);
			String coordenada = polygon.getElementsByTagName("coordinates").item(0).getTextContent();
			coordenadas += coordenada;
		}

		return coordenadas;
	}
}